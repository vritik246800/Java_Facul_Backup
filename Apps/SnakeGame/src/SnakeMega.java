/* SnakeMega.java
   Jogo "Cobrinha" com:
   - Skins: Neon, Retro, Digital, Chrome
   - Menu com botões
   - Obstáculos e níveis
   - Partículas ao apanhar maçã
   - IA (auto-play) com BFS
   - Replay recording & playback
   - Optional joystick support via JInput (detected at runtime)
   - Otimizações: fixed grid, double buffering, arrays fixos

   Compile:
     javac SnakeMega.java
   Run:
     java SnakeMega

   Optional (joystick):
     javac -cp jinput.jar SnakeMega.java
     java -cp .:jinput.jar SnakeMega
 */

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.text.SimpleDateFormat;

/* ---------- Main container ---------- */
public class SnakeMega {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameWindow gw = new GameWindow();
            gw.show();
        });
    }
}

/* ---------- Game Window + Menu ---------- */
class GameWindow {

    private final JFrame frame;
    private final CardLayout cards;
    private final JPanel container;
    private final GamePanel gamePanel;
    private final MenuPanel menuPanel;

    public GameWindow() {
        frame = new JFrame("Snake Mega — Deluxe Edition");
        cards = new CardLayout();
        container = new JPanel(cards);

        gamePanel = new GamePanel(this);
        menuPanel = new MenuPanel(this, gamePanel);

        container.add(menuPanel, "menu");
        container.add(gamePanel, "game");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(container);
        frame.setSize(800, 820);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    public void showMenu() {
        cards.show(container, "menu");
    }

    public void showGame() {
        cards.show(container, "game");
        gamePanel.requestFocusInWindow();
    }

    public void show() {
        frame.setVisible(true);
        showMenu();
    }
}

/* ---------- Menu Panel ---------- */
class MenuPanel extends JPanel {

    private final GameWindow parent;
    private final GamePanel gamePanel;
    private JComboBox<String> skinCombo, levelCombo;
    private JCheckBox soundCheck, aiCheck;
    private JButton startBtn, loadReplayBtn, exitBtn, optionsBtn, saveReplayBtn;

    public MenuPanel(GameWindow parent, GamePanel gp) {
        this.parent = parent;
        this.gamePanel = gp;
        setLayout(null);
        setBackground(new Color(12, 12, 20));

        JLabel title = new JLabel("SNAKE MEGA");
        title.setFont(new Font("Arial", Font.BOLD, 48));
        title.setForeground(Color.WHITE);
        title.setBounds(220, 40, 400, 60);
        add(title);

        startBtn = mkButton("Start Game", 300, 150, 200, 50);
        startBtn.addActionListener(e -> {
            applyOptionsToGame();
            parent.showGame();
        });
        add(startBtn);

        optionsBtn = mkButton("Options", 300, 220, 200, 45);
        optionsBtn.addActionListener(e -> showOptionsDialog());
        add(optionsBtn);

        loadReplayBtn = mkButton("Load Replay", 300, 280, 200, 45);
        loadReplayBtn.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File f = fc.getSelectedFile();
                boolean ok = gamePanel.loadReplayFromFile(f);
                if (ok) {
                    parent.showGame();
                }
            }
        });
        add(loadReplayBtn);

        exitBtn = mkButton("Exit", 300, 340, 200, 45);
        exitBtn.addActionListener(e -> System.exit(0));
        add(exitBtn);

        // Small info
        JLabel info = new JLabel("<html><center>Use arrow keys or WASD to play.<br>P to pause. G to toggle grid. R to restart.</center></html>", SwingConstants.CENTER);
        info.setForeground(Color.LIGHT_GRAY);
        info.setBounds(220, 420, 400, 60);
        add(info);
    }

    private JButton mkButton(String text, int x, int y, int w, int h) {
        JButton b = new JButton(text);
        b.setBounds(x, y, w, h);
        b.setFocusPainted(false);
        b.setFont(new Font("Arial", Font.BOLD, 16));
        return b;
    }

    private void showOptionsDialog() {
        JDialog d = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Options", true);
        d.setSize(400, 320);
        d.setLayout(null);
        d.setLocationRelativeTo(this);

        JLabel skinL = new JLabel("Skin:");
        skinL.setBounds(30, 20, 100, 25);
        d.add(skinL);
        skinCombo = new JComboBox<>(new String[]{"NEON", "RETRO", "DIGITAL", "CHROME"});
        skinCombo.setBounds(130, 20, 220, 25);
        d.add(skinCombo);

        JLabel levelL = new JLabel("Start Level:");
        levelL.setBounds(30, 60, 100, 25);
        d.add(levelL);
        levelCombo = new JComboBox<>(new String[]{"1", "2", "3", "4", "5"});
        levelCombo.setBounds(130, 60, 220, 25);
        d.add(levelCombo);

        soundCheck = new JCheckBox("Enable Sound", true);
        soundCheck.setBounds(30, 100, 200, 25);
        d.add(soundCheck);

        aiCheck = new JCheckBox("Start with AI", false);
        aiCheck.setBounds(30, 130, 200, 25);
        d.add(aiCheck);

        JButton apply = new JButton("Apply & Close");
        apply.setBounds(120, 200, 140, 35);
        apply.addActionListener(e -> {
            applyOptionsToGame();
            d.dispose();
        });
        d.add(apply);

        d.setVisible(true);
    }

    private void applyOptionsToGame() {
        String skin = (skinCombo == null) ? "NEON" : (String) skinCombo.getSelectedItem();
        int level = (levelCombo == null) ? 1 : Integer.parseInt((String) levelCombo.getSelectedItem());
        boolean sound = (soundCheck == null) ? true : soundCheck.isSelected();
        boolean ai = (aiCheck == null) ? false : aiCheck.isSelected();

        gamePanel.setSkin(Skin.valueOf(skin));
        gamePanel.setLevel(level);
        gamePanel.setSoundEnabled(sound);
        gamePanel.setAiEnabled(ai);
    }
}

/* ---------- Game Panel (core) ---------- */
class GamePanel extends JPanel implements ActionListener {

    // Fixed grid for performance
    private static final int SCREEN_WIDTH = 600;
    private static final int SCREEN_HEIGHT = 600;
    private static final int UNIT_SIZE = 20; // smaller units -> more precise movement
    private static final int COLS = SCREEN_WIDTH / UNIT_SIZE;
    private static final int ROWS = SCREEN_HEIGHT / UNIT_SIZE;
    private static final int MAX_UNITS = COLS * ROWS;

    // Game state
    private final int[] x = new int[MAX_UNITS];
    private final int[] y = new int[MAX_UNITS];
    private int bodyParts = 6;
    private int applesEaten = 0;
    private int appleX, appleY;

    private int level = 1;
    private final List<Point> obstacles = new ArrayList<>();
    private final Random random = new Random();

    // timing & rendering
    private int delay = 120;
    private Timer timer;
    private boolean running = false;
    public boolean paused = false;
    private boolean showGrid = false;
    private boolean soundEnabled = true;

    // skins & particles
    private Skin skin = Skin.NEON;
    private final ParticleSystem particles = new ParticleSystem();

    // highscore
    private int highscore = 0;
    private final File highscoreFile = new File("highscore.txt");

    // replay system
    private final ReplayRecorder recorder = new ReplayRecorder();

    // AI
    private boolean aiEnabled = false;
    private final AIController aiController;

    // joystick handler (optional)
    private final OptionalJoystick joystick;

    private final GameWindow parent;

    // sounds
    private ClipPlayer clipEat = new ClipPlayer("eat.wav");
    private ClipPlayer clipGameOver = new ClipPlayer("gameover.wav");

    public GamePanel(GameWindow parent) {
        this.parent = parent;
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        setDoubleBuffered(true);

        addKeyListener(new KL());
        addMouseListener(new ML());

        aiController = new AIController(this);
        joystick = new OptionalJoystick(this);

        loadHighscore();
        initGame();
    }

    public void setSkin(Skin s) {
        this.skin = s;
        repaint();
    }

    public void setLevel(int lvl) {
        this.level = Math.max(1, Math.min(10, lvl));
    }

    public void setSoundEnabled(boolean v) {
        this.soundEnabled = v;
    }

    public void setAiEnabled(boolean v) {
        this.aiEnabled = v;
    }

    private void loadHighscore() {
        try {
            if (highscoreFile.exists()) {
                List<String> lines = Files.readAllLines(highscoreFile.toPath());
                if (!lines.isEmpty()) {
                    highscore = Integer.parseInt(lines.get(0));
                }
            }
        } catch (Exception ignored) {
        }
    }

    private void saveHighscore() {
        try {
            Files.write(highscoreFile.toPath(), Collections.singletonList(String.valueOf(highscore)));
        } catch (Exception ignored) {
        }
    }

    private void initGame() {
        // initial snake in middle
        bodyParts = 6;
        applesEaten = 0;
        int startX = (COLS / 2) * UNIT_SIZE;
        int startY = (ROWS / 2) * UNIT_SIZE;
        for (int i = 0; i < bodyParts; i++) {
            x[i] = startX - i * UNIT_SIZE;
            y[i] = startY;
        }
        placeObstaclesForLevel(level);
        placeApple();
        delay = 120;
        running = true;
        paused = false;
        recorder.clear();
        recorder.recordEvent("START", System.currentTimeMillis());
        startTimer();
    }

    private void placeObstaclesForLevel(int lvl) {
        obstacles.clear();
        int base = Math.min(50, lvl * 6); // more level => more obstacles
        for (int i = 0; i < base; i++) {
            int ox, oy;
            int attempts = 0;
            do {
                ox = random.nextInt(COLS) * UNIT_SIZE;
                oy = random.nextInt(ROWS) * UNIT_SIZE;
                attempts++;
            } while (isOnSnake(ox, oy) && attempts < 30);
            obstacles.add(new Point(ox, oy));
        }
        // create some structured obstacles for higher levels
        if (lvl >= 3) {
            for (int r = 10; r < 20 && obstacles.size() < base + 20; r++) {
                obstacles.add(new Point(r * UNIT_SIZE, 10 * UNIT_SIZE));
            }
        }
    }

    private boolean isOnSnake(int px, int py) {
        for (int i = 0; i < bodyParts; i++) {
            if (x[i] == px && y[i] == py) {
                return true;
            }
        }
        return false;
    }

    private void placeApple() {
        int ax, ay;
        int attempts = 0;
        do {
            ax = random.nextInt(COLS) * UNIT_SIZE;
            ay = random.nextInt(ROWS) * UNIT_SIZE;
            attempts++;
        } while ((isOnSnake(ax, ay) || obstacles.contains(new Point(ax, ay))) && attempts < 2000);
        appleX = ax;
        appleY = ay;
    }

    private void startTimer() {
        if (timer != null) {
            timer.stop();
        }
        timer = new Timer(delay, this);
        timer.start();
    }

    // Game loop
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!running) {
            return;
        }
        // joystick poll
        joystick.poll();

        if (!paused) {
            if (aiEnabled) {
                Direction d = aiController.nextMove(x[0], y[0], appleX, appleY, bodyParts, x, y, obstacles);
                if (d != null) {
                    changeDirection(d);
                }
            }
            move();
            checkApple();
            checkCollisions();
            particles.update();
            recorder.tick(); // let recorder capture time
        }
        repaint();
    }

    // Drawing
    @Override
    protected void paintComponent(Graphics g0) {
        super.paintComponent(g0);
        Graphics2D g = (Graphics2D) g0.create();

        // background
        g.setColor(new Color(8, 8, 10));
        g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        // grid optional
        if (showGrid) {
            g.setColor(new Color(30, 30, 30));
            for (int i = 0; i <= COLS; i++) {
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
            }
            for (int j = 0; j <= ROWS; j++) {
                g.drawLine(0, j * UNIT_SIZE, SCREEN_WIDTH, j * UNIT_SIZE);
            }
        }

        // obstacles
        g.setColor(new Color(80, 80, 80));
        for (Point p : obstacles) {
            g.fillRect(p.x, p.y, UNIT_SIZE, UNIT_SIZE);
        }

        // apple
        skin.drawApple(g, appleX, appleY, UNIT_SIZE);

        // snake
        for (int i = 0; i < bodyParts; i++) {
            int sx = x[i], sy = y[i];
            if (i == 0) {
                skin.drawHead(g, sx, sy, UNIT_SIZE); 
            }else {
                skin.drawBody(g, sx, sy, UNIT_SIZE, i, bodyParts);
            }
        }

        // particles
        particles.render(g);

        // UI overlay
        g.setColor(Color.WHITE);
        g.setFont(new Font("Monospaced", Font.BOLD, 14));
        g.drawString("Score: " + applesEaten, 10, 18);
        g.drawString("High: " + highscore, 10, 36);
        g.drawString("Level: " + level, 10, 54);
        g.drawString("Delay: " + delay + "ms", 10, 72);

        if (paused) {
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.setColor(Color.YELLOW);
            g.drawString("PAUSED", SCREEN_WIDTH / 2 - 70, SCREEN_HEIGHT / 2);
        }

        g.dispose();
    }

    // Movement & controls
    private char direction = 'R'; // U D L R

    private void move() {
        // move body
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        // head
        switch (direction) {
            case 'U' ->
                y[0] -= UNIT_SIZE;
            case 'D' ->
                y[0] += UNIT_SIZE;
            case 'L' ->
                x[0] -= UNIT_SIZE;
            case 'R' ->
                x[0] += UNIT_SIZE;
        }
    }

    public void changeDirection(Direction d) {
        char newDir = switch (d) {
            case UP ->
                'U';
            case DOWN ->
                'D';
            case LEFT ->
                'L';
            case RIGHT ->
                'R';
        };
        if ((direction == 'L' && newDir == 'R')
                || (direction == 'R' && newDir == 'L')
                || (direction == 'U' && newDir == 'D')
                || (direction == 'D' && newDir == 'U')) {
            return; // no reverse
        }
        if (direction != newDir) {
            direction = newDir;
            recorder.recordMove(newDir);
        }
    }

    private void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            bodyParts++;
            applesEaten++;
            particles.emit(appleX + UNIT_SIZE / 2, appleY + UNIT_SIZE / 2, skin);
            if (soundEnabled) {
                clipEat.play();
            }
            // speed up smoothly
            delay = Math.max(30, delay - 2);
            timer.setDelay(delay);
            placeApple();
            recorder.recordEvent("APPLE", System.currentTimeMillis());
            // level up every 5 apples
            if (applesEaten % 5 == 0) {
                level++;
                placeObstaclesForLevel(level);
            }
        }
    }

    private void checkCollisions() {
        // collisions with body
        for (int i = 1; i < bodyParts; i++) {
            if (x[0] == x[i] && y[0] == y[i]) {
                gameOver();
                return;
            }
        }
        // walls
        if (x[0] < 0 || x[0] >= SCREEN_WIDTH || y[0] < 0 || y[0] >= SCREEN_HEIGHT) {
            gameOver();
            return;
        }
        // obstacles
        for (Point p : obstacles) {
            if (x[0] == p.x && y[0] == p.y) {
                gameOver();
                return;
            }
        }
    }

    private void gameOver() {
        running = false;
        timer.stop();
        recorder.recordEvent("GAMEOVER", System.currentTimeMillis());
        if (applesEaten > highscore) {
            highscore = applesEaten;
            saveHighscore();
        }
        if (soundEnabled) {
            clipGameOver.play();
        }
        // popup to ask replay/save
        SwingUtilities.invokeLater(() -> {
            String[] opts = {"Restart", "Save Replay", "Back to Menu"};
            int choice = JOptionPane.showOptionDialog(this,
                    "Game Over\nScore: " + applesEaten,
                    "Game Over",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
            if (choice == JOptionPane.YES_OPTION) {
                initGame();
            } else if (choice == JOptionPane.NO_OPTION) {
                saveReplayQuick();
            } else {
                parent.showMenu();
            }
        });
    }

    // Replay helpers
    public boolean loadReplayFromFile(File f) {
        try {
            Replay rec = Replay.loadFromFile(f);
            playReplay(rec);
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar replay: " + ex.getMessage());
            return false;
        }
    }

    private void playReplay(Replay rec) {
        // stop current game
        if (timer != null) {
            timer.stop();
        }
        running = false;
        paused = false;
        // start a runner thread to play back events deterministically
        new Thread(() -> {
            try {
                // reset world
                initGame();
                running = true;
                paused = false;
                // override recorder to disabled while playing
                recorder.disable();
                long start = System.currentTimeMillis();
                for (Replay.Event e : rec.events) {
                    long t = e.timestamp;
                    long now = System.currentTimeMillis() - start;
                    if (t > now) {
                        Thread.sleep(t - now);
                    }
                    if (e.type.equals("MOVE")) {
                        char d = e.data.charAt(0);
                        direction = d;
                    } else if (e.type.equals("APPLE")) {
                        // simulate apple event (we already move naturally)
                    } else if (e.type.equals("GAMEOVER")) {
                        break;
                    }
                    // Wait until next timer tick
                    Thread.sleep(Math.max(0, delay));
                }
                recorder.enable();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    private void saveReplayQuick() {
        try {
            Replay r = recorder.exportReplay();
            String name = "replay_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".rpy";
            Files.write(Paths.get(name), r.serialize().getBytes());
            JOptionPane.showMessageDialog(this, "Replay salvo: " + name);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Falha a salvar replay: " + ex.getMessage());
        }
    }

    // Input handlers
    private class KL extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int k = e.getKeyCode();
            if (k == KeyEvent.VK_LEFT || k == KeyEvent.VK_A) {
                changeDirection(Direction.LEFT); 
            }else if (k == KeyEvent.VK_RIGHT || k == KeyEvent.VK_D) {
                changeDirection(Direction.RIGHT); 
            }else if (k == KeyEvent.VK_UP || k == KeyEvent.VK_W) {
                changeDirection(Direction.UP); 
            }else if (k == KeyEvent.VK_DOWN || k == KeyEvent.VK_S) {
                changeDirection(Direction.DOWN); 
            }else if (k == KeyEvent.VK_P) {
                paused = !paused; 
            }else if (k == KeyEvent.VK_G) {
                showGrid = !showGrid; 
            }else if (k == KeyEvent.VK_R) {
                initGame(); 
            }else if (k == KeyEvent.VK_H) {
                saveReplayQuick();
            }
            // record keypress event
            recorder.recordEvent("KEY_" + k, System.currentTimeMillis());
        }
    }

    private class ML extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            requestFocusInWindow();
        }
    }

    // Utilities
    private boolean insideGrid(int gx, int gy) {
        return gx >= 0 && gx < COLS && gy >= 0 && gy < ROWS;
    }

    // For AI accessors
    public int getCols() {
        return COLS;
    }

    public int getRows() {
        return ROWS;
    }

    public int getUnit() {
        return UNIT_SIZE;
    }

    public boolean isCellBlocked(int cx, int cy, int snakeLen, int[] sx, int[] sy) {
        int px = cx * UNIT_SIZE, py = cy * UNIT_SIZE;
        // check obstacles
        if (obstacles.contains(new Point(px, py))) {
            return true;
        }
        // check snake body
        for (int i = 0; i < snakeLen; i++) {
            if (sx[i] == px && sy[i] == py) {
                return true;
            }
        }
        return false;
    }

    // Replay recorder inner classes
    static class Replay {

        static class Event {

            final String type;
            final long timestamp;
            final String data;

            Event(String t, long ts, String d) {
                type = t;
                timestamp = ts;
                data = d;
            }
        }
        final List<Event> events = new ArrayList<>();

        String serialize() {
            StringBuilder sb = new StringBuilder();
            for (Event e : events) {
                sb.append(e.type).append("|").append(e.timestamp).append("|").append(e.data.replace("|", "/")).append("\n");
            }
            return sb.toString();
        }

        static Replay loadFromFile(File f) throws IOException {
            List<String> lines = Files.readAllLines(f.toPath());
            Replay r = new Replay();
            for (String l : lines) {
                if (l.trim().isEmpty()) {
                    continue;
                }
                String[] parts = l.split("\\|", 3);
                String type = parts[0];
                long ts = Long.parseLong(parts[1]);
                String data = parts.length > 2 ? parts[2] : "";
                r.events.add(new Event(type, ts, data));
            }
            return r;
        }
    }

    // Recorder implementation (records moves & events with timestamps relative)
    static class ReplayRecorder {

        private final List<Replay.Event> events = Collections.synchronizedList(new ArrayList<>());
        private long startTime = System.currentTimeMillis();
        private volatile boolean enabled = true;

        public void clear() {
            events.clear();
            startTime = System.currentTimeMillis();
        }

        public void recordMove(char dir) {
            if (!enabled) {
                return;
            }
            long t = System.currentTimeMillis() - startTime;
            events.add(new Replay.Event("MOVE", t, "" + dir));
        }

        public void recordEvent(String type, long absTs) {
            if (!enabled) {
                return;
            }
            long t = absTs - startTime;
            events.add(new Replay.Event(type, t, ""));
        }

        public void tick() {
            // called each game tick for timing alignment (optionally record)
        }

        public Replay exportReplay() {
            Replay r = new Replay();
            r.events.addAll(events);
            return r;
        }

        public void disable() {
            enabled = false;
        }

        public void enable() {
            enabled = true;
            startTime = System.currentTimeMillis();
        }
    }

    // Small ClipPlayer for WAV playback without hard failure if missing
    static class ClipPlayer {

        private final String fileName;

        public ClipPlayer(String fn) {
            this.fileName = fn;
        }

        public void play() {
            // Lightweight play: use Toolkit beep fallback if file missing
            new Thread(() -> {
                try {
                    File f = new File(fileName);
                    if (!f.exists()) {
                        Toolkit.getDefaultToolkit().beep();
                        return;
                    }
                    javax.sound.sampled.AudioInputStream ais = javax.sound.sampled.AudioSystem.getAudioInputStream(f);
                    javax.sound.sampled.Clip clip = javax.sound.sampled.AudioSystem.getClip();
                    clip.open(ais);
                    clip.start();
                } catch (Exception e) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }).start();
        }
    }
}

/* ---------- Skin enum (draws apple, head, body differently) ---------- */
enum Skin {
    NEON {
        @Override
        void drawHead(Graphics2D g, int x, int y, int size) {
            GradientPaint gp = new GradientPaint(x, y, Color.CYAN, x + size, y + size, Color.MAGENTA);
            g.setPaint(gp);
            g.fillRoundRect(x, y, size, size, 6, 6);
            g.setColor(Color.WHITE);
            g.drawRoundRect(x + 1, y + 1, size - 2, size - 2, 6, 6);
        }

        @Override
        void drawBody(Graphics2D g, int x, int y, int size, int idx, int total) {
            float t = (idx % 5) / 5f;
            Color c = new Color(0, (int) (180 * (1 - t)), 255);
            g.setColor(c);
            g.fillRect(x, y, size, size);
        }

        @Override
        void drawApple(Graphics2D g, int x, int y, int size) {
            g.setColor(Color.PINK);
            g.fillOval(x, y, size, size);
            g.setColor(Color.WHITE);
            g.drawOval(x, y, size, size);
        }
    },
    RETRO {
        @Override
        void drawHead(Graphics2D g, int x, int y, int size) {
            g.setColor(new Color(0, 120, 0));
            g.fillRect(x, y, size, size);
        }

        @Override
        void drawBody(Graphics2D g, int x, int y, int size, int idx, int total) {
            g.setColor(new Color(0, 100, 0));
            g.fillRect(x, y, size, size);
            g.setColor(new Color(30, 30, 30, 40));
            g.fillRect(x + 2, y + 2, size - 4, size - 4);
        }

        @Override
        void drawApple(Graphics2D g, int x, int y, int size) {
            g.setColor(new Color(180, 20, 20));
            g.fillOval(x, y, size, size);
        }
    },
    DIGITAL {
        @Override
        void drawHead(Graphics2D g, int x, int y, int size) {
            g.setColor(new Color(70, 70, 200));
            g.fillRect(x, y, size, size);
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(x + 3, y + 3, size - 6, size - 6);
        }

        @Override
        void drawBody(Graphics2D g, int x, int y, int size, int idx, int total) {
            if (idx % 2 == 0) {
                g.setColor(new Color(20, 20, 60)); 
            }else {
                g.setColor(new Color(30, 30, 100));
            }
            g.fillRect(x, y, size, size);
        }

        @Override
        void drawApple(Graphics2D g, int x, int y, int size) {
            g.setColor(new Color(255, 120, 0));
            g.fillOval(x, y, size, size);
        }
    },
    CHROME {
        @Override
        void drawHead(Graphics2D g, int x, int y, int size) {
            GradientPaint gp = new GradientPaint(x, y, Color.LIGHT_GRAY, x + size, y + size, Color.DARK_GRAY);
            g.setPaint(gp);
            g.fillRoundRect(x, y, size, size, 8, 8);
        }

        @Override
        void drawBody(Graphics2D g, int x, int y, int size, int idx, int total) {
            GradientPaint gp = new GradientPaint(x, y, Color.WHITE, x + size, y + size, Color.GRAY);
            g.setPaint(gp);
            g.fillRect(x, y, size, size);
        }

        @Override
        void drawApple(Graphics2D g, int x, int y, int size) {
            GradientPaint gp = new GradientPaint(x, y, Color.RED, x + size, y + size, new Color(139, 0, 0));
            g.setPaint(gp);
            g.fillOval(x, y, size, size);
        }
    };

    abstract void drawHead(Graphics2D g, int x, int y, int size);

    abstract void drawBody(Graphics2D g, int x, int y, int size, int idx, int total);

    abstract void drawApple(Graphics2D g, int x, int y, int size);
}

/* ---------- Particle System ---------- */
class ParticleSystem {

    private final List<Particle> parts = Collections.synchronizedList(new ArrayList<>());
    private final Random rand = new Random();

    public void emit(int cx, int cy, Skin skin) {
        int n = 18 + rand.nextInt(10);
        for (int i = 0; i < n; i++) {
            parts.add(new Particle(cx, cy, (rand.nextDouble() - 0.5) * 4, (rand.nextDouble() - 1.5) * 4, 600 + rand.nextInt(400), skin));
        }
    }

    public void update() {
        long now = System.currentTimeMillis();
        parts.removeIf(p -> !p.update(now));
    }

    public void render(Graphics2D g) {
        synchronized (parts) {
            for (Particle p : parts) {
                p.render(g);
            }
        }
    }

    static class Particle {

        double x, y, vx, vy;
        long born, life;
        final Skin skin;

        public Particle(double x, double y, double vx, double vy, long life, Skin s) {
            this.x = x;
            this.y = y;
            this.vx = vx;
            this.vy = vy;
            this.born = System.currentTimeMillis();
            this.life = life;
            this.skin = s;
        }

        boolean update(long now) {
            double t = (now - born) / 1000.0;
            x += vx;
            y += vy + 0.5 * t;
            return now - born < life;
        }

        void render(Graphics2D g) {
            long age = System.currentTimeMillis() - born;
            float alpha = Math.max(0, 1f - (float) age / (float) life);
            Composite old = g.getComposite();
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
            int s = 4;
            g.setColor(Color.YELLOW);
            g.fill(new Ellipse2D.Double(x - s / 2, y - s / 2, s, s));
            g.setComposite(old);
        }
    }
}

/* ---------- Simple BFS AI Controller ---------- */
enum Direction {
    UP, DOWN, LEFT, RIGHT
}

class AIController {

    private final GamePanel gp;

    public AIController(GamePanel gp) {
        this.gp = gp;
    }

    // returns next Direction (or null to keep)
    public Direction nextMove(int hx, int hy, int ax, int ay, int bodyLen, int[] sx, int[] sy, List<Point> obstacles) {
        int cols = gp.getCols();
        int rows = gp.getRows();
        int unit = gp.getUnit();
        int startX = hx / unit;
        int startY = hy / unit;
        int goalX = ax / unit;
        int goalY = ay / unit;

        boolean[][] blocked = new boolean[cols][rows];
        for (Point p : obstacles) {
            blocked[p.x / unit][p.y / unit] = true;
        }
        for (int i = 0; i < bodyLen; i++) {
            if (i == 0) {
                continue; // allow head cell

                        }blocked[sx[i] / unit][sy[i] / unit] = true;
        }

        // BFS
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        boolean[][] vis = new boolean[cols][rows];
        int[][] px = new int[cols][rows];
        int[][] py = new int[cols][rows];
        int[][] pd = new int[cols][rows];
        dq.add(new int[]{startX, startY});
        vis[startX][startY] = true;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int[] dirIdx = {0, 1, 2, 3};
        boolean found = false;
        while (!dq.isEmpty()) {
            int[] c = dq.poll();
            if (c[0] == goalX && c[1] == goalY) {
                found = true;
                break;
            }
            for (int k = 0; k < 4; k++) {
                int nx = c[0] + dx[k], ny = c[1] + dy[k];
                if (nx < 0 || nx >= cols || ny < 0 || ny >= rows) {
                    continue;
                }
                if (vis[nx][ny]) {
                    continue;
                }
                if (blocked[nx][ny]) {
                    continue;
                }
                vis[nx][ny] = true;
                px[nx][ny] = c[0];
                py[nx][ny] = c[1];
                pd[nx][ny] = k;
                dq.add(new int[]{nx, ny});
            }
        }
        if (!found) {
            return null;
        }
        // reconstruct path from goal to start
        int cx = goalX, cy = goalY;
        int lastDir = -1;
        while (!(cx == startX && cy == startY)) {
            lastDir = pd[cx][cy];
            int tx = px[cx][cy], ty = py[cx][cy];
            cx = tx;
            cy = ty;
        }
        if (lastDir == 0) {
            return Direction.UP;
        }
        if (lastDir == 1) {
            return Direction.DOWN;
        }
        if (lastDir == 2) {
            return Direction.LEFT;
        }
        return Direction.RIGHT;
    }
}

/* ---------- Optional joystick support via runtime reflection (JInput) ---------- */
class OptionalJoystick {

    private final GamePanel gp;
    private Object controllerEnv = null;
    private Object[] controllers = null;
    private boolean available = false;

    public OptionalJoystick(GamePanel gp) {
        this.gp = gp;
        // Try to detect JInput at runtime
        try {
            Class<?> ce = Class.forName("net.java.games.input.ControllerEnvironment");
            Object env = ce.getMethod("getDefaultEnvironment").invoke(null);
            Object[] ctrs = (Object[]) env.getClass().getMethod("getControllers").invoke(env);
            if (ctrs != null && ctrs.length > 0) {
                controllerEnv = env;
                controllers = ctrs;
                available = true;
                System.out.println("JInput controllers detected: " + ctrs.length);
            }
        } catch (Exception e) {
            // no JInput found; joystick unavailable
            available = false;
        }
    }

    public void poll() {
        if (!available) {
            return;
        }
        try {
            for (Object c : controllers) {
                String type = c.getClass().getMethod("getType").invoke(c).toString();
                // only process gamepad/joystick types
                if (!type.toLowerCase().contains("stick") && !type.toLowerCase().contains("gamepad")) {
                    continue;
                }
                boolean polled = (boolean) c.getClass().getMethod("poll").invoke(c);
                if (!polled) {
                    continue;
                }
                Object[] components = (Object[]) c.getClass().getMethod("getComponents").invoke(c);
                for (Object comp : components) {
                    String compName = (String) comp.getClass().getMethod("getName").invoke(comp);
                    float value = (float) comp.getClass().getMethod("getPollData").invoke(comp);
                    // simple axis mapping: value < -0.5 -> left/up ; > 0.5 -> right/down
                    if (compName.toLowerCase().contains("x") || compName.toLowerCase().contains("rx")) {
                        if (value < -0.5f) {
                            gp.changeDirection(Direction.LEFT); 
                        }else if (value > 0.5f) {
                            gp.changeDirection(Direction.RIGHT);
                        }
                    }
                    if (compName.toLowerCase().contains("y") || compName.toLowerCase().contains("ry")) {
                        if (value < -0.5f) {
                            gp.changeDirection(Direction.UP); 
                        }else if (value > 0.5f) {
                            gp.changeDirection(Direction.DOWN);
                        }
                    }
                    // buttons can map to pause/restart etc.
                    if (compName.toLowerCase().contains("button")) {
                        if (value > 0.5f) {
                            // map button 0 -> pause
                            gp.paused = !gp.paused;
                        }
                    }
                }
            }
        } catch (Exception e) {
            // ignore joystick errors at runtime
        }
    }
}

/* ---------- END OF FILE ---------- */
