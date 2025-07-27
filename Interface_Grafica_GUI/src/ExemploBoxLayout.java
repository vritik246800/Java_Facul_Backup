import javax.swing.*;
import java.awt.*;

public class ExemploBoxLayout
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Exemplo BoxLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS)); // vertical

        painel.add(new JButton("Botão 1"));
        painel.add(Box.createRigidArea(new Dimension(0, 10))); // espaço entre botões
        painel.add(new JButton("Botão 2"));
        painel.add(Box.createRigidArea(new Dimension(0, 10)));
        painel.add(new JButton("Botão 3"));

        frame.getContentPane().add(painel);
        frame.setVisible(true);
    }
}
