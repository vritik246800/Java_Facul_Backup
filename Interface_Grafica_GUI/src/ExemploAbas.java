import javax.swing.*;
import java.awt.*;

public class ExemploAbas
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Exemplo com Abas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTabbedPane abas = new JTabbedPane();

        // Criando os painéis das abas
        JPanel painel1 = new JPanel();
        painel1.add(new JLabel("Conteúdo da Aba 1"));

        JPanel painel2 = new JPanel();
        painel2.add(new JLabel("Conteúdo da Aba 2"));

        // Adicionando as abas
        abas.addTab("Aba 1", painel1);
        abas.addTab("Aba 2", painel2);

        // Adiciona o JTabbedPane ao frame
        frame.getContentPane().add(abas);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
