import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginWindow extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JComboBox<String> comboUsers;
    private JButton btnLogin, btnRegister;
    private Container c;

    public LoginWindow() {
        setTitle("Login");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Painel com imagem de fundo
        setContentPane(new JLabel(new ImageIcon("background.jpg")));
        setLayout(null);

        JLabel lblUser = new JLabel("Utilizador:");
        lblUser.setBounds(120, 80, 100, 30);
        lblUser.setForeground(Color.WHITE);
        add(lblUser);

        comboUsers = new JComboBox<>(new String[]{"Admin", "User1", "User2"});
        comboUsers.setBounds(220, 80, 150, 30);
        add(comboUsers);

        JLabel lblPassword = new JLabel("Senha:");
        lblPassword.setBounds(120, 130, 100, 30);
        lblPassword.setForeground(Color.WHITE);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(220, 130, 150, 30);
        add(txtPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(120, 200, 110, 30);
        add(btnLogin);

        btnRegister = new JButton("Registrar");
        btnRegister.setBounds(260, 200, 110, 30);
        add(btnRegister);

        // Eventos
        btnLogin.addActionListener(e -> {
            String user = (String) comboUsers.getSelectedItem();
            String password = new String(txtPassword.getPassword());
            if (password.equals("1234")) {
                JOptionPane.showMessageDialog(this, "Bem-vindo " + user + "!");
            } else {
                JOptionPane.showMessageDialog(this, "Senha incorreta!");
            }
        });

        btnRegister.addActionListener(e -> {
            String newUser = JOptionPane.showInputDialog(this, "Novo nome de utilizador:");
            if (newUser != null && !newUser.trim().isEmpty()) {
                comboUsers.addItem(newUser);
            }
        });
        setBackground(new Color(34, 139, 34));
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new LoginWindow().setVisible(true));
    }
}