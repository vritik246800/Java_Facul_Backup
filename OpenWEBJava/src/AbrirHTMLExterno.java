import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.*;

public class AbrirHTMLExterno {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Abrir HTML no Navegador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JButton btnAbrir = new JButton("Abrir HTML");
        btnAbrir.addActionListener(e -> {
            try {
                File arquivoHTML = new File("arquivo.html"); 
                if (arquivoHTML.exists() && Desktop.isDesktopSupported()) {
                    // abre site externo
                    Desktop.getDesktop().browse(new URI("https://google.com"));
                    
                    // ou abre arquivo local
                    // Desktop.getDesktop().browse(arquivoHTML.toURI());
                } else {
                    JOptionPane.showMessageDialog(frame, "Não foi possível abrir o arquivo.");
                }
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace();
            }
        });

        frame.add(btnAbrir);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
