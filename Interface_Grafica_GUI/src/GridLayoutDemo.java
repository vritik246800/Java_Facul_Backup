import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridLayoutDemo extends JFrame 
{
    private JButton[] buttons;
    private String[] names = 
    	{
    		"one", "two", "three", "four", "five", "six" 
    	};
    private boolean op = true;
    private Container cont;
    private GridLayout grid1, grid2;

    public GridLayoutDemo() 
    {
        super("teste de GridLayout");

        // configura os layouts
        grid1 = new GridLayout(2, 3, 5, 5); // tabela de 2x3 com espaçamento (5,5)
        //                     |  |  |  |>espacamento coluna
        //                     |  |  |>espacamento linha
        //                     |  |>coluna
        //                     |>linha
        grid2 = new GridLayout(3, 2);       // cria tabela de 3x2 sem espaçamento

        cont = getContentPane();
        cont.setLayout(grid1);

        TrataEv x = new TrataEv();

        // cria e adiciona botões
        buttons = new JButton[names.length];
        for (int i = 0; i < names.length; i++) 
        {
            buttons[i] = new JButton(names[i]);
            buttons[i].addActionListener(x);
            buttons[i].setBackground(Color.DARK_GRAY);
            cont.add(buttons[i]); // adiciona por linhas
        }

        setSize(500,500);
        setVisible(true);
        setLocationRelativeTo(null);
        cont.setBackground(Color.orange);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class TrataEv implements ActionListener
    {
        public void actionPerformed(ActionEvent event) 
        {
            if (op)
                cont.setLayout(grid2);
            else
                cont.setLayout(grid1);
            op = !op; // alterna o valor de op
            cont.validate(); // atualiza o container com o novo layout
        }
    }

    public static void main(String[] args) 
    {
        new GridLayoutDemo();
    }
}
