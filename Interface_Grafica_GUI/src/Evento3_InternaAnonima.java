// CLASS implenta Interna Anonila

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Evento3_InternaAnonima extends JFrame
{
	private JButton b1;
	private JLabel l1;
	private int ct=0;
	private Container c;
	
	public Evento3_InternaAnonima()
	{
		super("Evento_3");
		c=getContentPane();
		c.setLayout(new FlowLayout());
		
		ct=0;
		
		b1=new JButton("Igual: ");
		
		// NOTA para cada butao tem quer ter essa estrutua so o content muda
		b1.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent av)
				{
					ct++;
					l1.setText("Total de cliques: "+ct);
				}
			}
		);
		
		c.add(b1);
		
		l1=new JLabel("Total de cliques: "+ct);
		l1.setForeground(Color.blue);
		c.add(l1);
		
		setSize(200,300);
		setVisible(true);
		
	}
	public static void main(String [] args)
	{
		Evento3_InternaAnonima e=new Evento3_InternaAnonima();
		e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		e.setLocationRelativeTo(null);
		e.setVisible(true);
	}

}

