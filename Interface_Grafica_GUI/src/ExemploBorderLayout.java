import javax.swing.*;
import java.awt.*;

public class ExemploBorderLayout extends JFrame
 {
    public ExemploBorderLayout()
    {
        setTitle("Exemplo BorderLayout");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(new JButton("NORTE"), BorderLayout.NORTH);
        add(new JButton("SUL"), BorderLayout.SOUTH);
        add(new JButton("LESTE"), BorderLayout.EAST);
        add(new JButton("OESTE"), BorderLayout.WEST);
        add(new JButton("CENTRO"), BorderLayout.CENTER);
    }

    public static void main(String[] args) 
    {
    	new ExemploBorderLayout().setVisible(true);
        /*SwingUtilities.invokeLater
        (
            () -> 
            {
                new ExemploBorderLayout().setVisible(true);
            }
        );*/
    }
}
