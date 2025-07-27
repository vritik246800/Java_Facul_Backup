import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RecargasV3 extends JFrame
{
	private Container c;
	private JTextField t1,t2,t3;
	private JButton b1;
	private JLabel l1,l2,l3;
	
	public RecargasV3()
	{
		
		
		super("RecargasV3");
		
		Icon imagem=new ImageIcon("voda.jpeg");
		c=getContentPane();
		c.setLayout(new FlowLayout());
		
		l1=new JLabel("Recargas: ",imagem,SwingConstants.LEFT);
		l1.setToolTipText("Introduz o valor das recargas (>0)");
		c.add(l1);
		
		t1=new JTextField(10);
		c.add(t1);
		
		l2=new JLabel("Quantidade: ",imagem,SwingConstants.LEFT);
		l2.setToolTipText("Introduz a quantidade de recargas (>0)");
		c.add(l2);
		
		t2=new JTextField(10);
		c.add(t2);
		
		l3=new JLabel("Total: ");
		c.add(l3);
		
		t3=new JTextField(10);
		t3.setEditable(false);
		c.add(t3);
		
		b1=new JButton("Calcular");
		b1.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
					int valorRecarga=Integer.parseInt(t1.getText());
					int quatidade=Integer.parseInt(t2.getText());
					int total=valorRecarga*quatidade;
					
					t3.setForeground(Color.RED);
					t3.setText(total+"");
				}
			}
		);
		c.add(b1);
		
		setSize(250,200);
		setVisible(true);
	}
	public static void main(String [] args)
	{
		RecargasV3 z=new RecargasV3();
		z.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		z.setLocationRelativeTo(null);
		//            |> para centralizar a janela
		z.setResizable(true);
		//            |> para que permite e nao permitir o resizable
	}
	
}
