import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExemploCardLayout extends JFrame 
{
    CardLayout cardLayout;
    JPanel painelPrincipal;

    public ExemploCardLayout() 
    {
        super("Exemplo CardLayout");

        // Inicializa o CardLayout
        cardLayout = new CardLayout();
        painelPrincipal = new JPanel(cardLayout);

        // Telas
        JPanel tela1 = new JPanel();
        tela1.setBackground(Color.green);
        tela1.add(new JLabel("Tela 1"));
        JButton butao1 = new JButton("Ir para Tela 2");
        tela1.add(butao1);

        JPanel tela2 = new JPanel();
        tela2.setBackground(Color.gray);
        tela2.add(new JLabel("Tela 2"));
        JButton butao2 = new JButton("Voltar para Tela 1");
        tela2.add(butao2);

        // Adiciona as telas ao painel principal
        painelPrincipal.add(tela1, "t1");
        painelPrincipal.add(tela2, "t2");

        // Listeners para mudar de tela
        butao1.addActionListener(e -> cardLayout.show(painelPrincipal, "t2"));
        butao2.addActionListener(e -> cardLayout.show(painelPrincipal, "t1"));

        // Configura a janela
        add(painelPrincipal);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) 
    {
        new ExemploCardLayout();
    }
}
