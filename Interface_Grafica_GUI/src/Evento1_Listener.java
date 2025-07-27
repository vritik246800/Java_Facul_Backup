// CLASS implementa Listener

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Evento1_Listener extends JFrame implements ActionListener
{
	private JButton b1;
	private JLabel l1;
	private int ct=0;
	private Container c;
	
	public Evento1_Listener()
	{
		super("Evento_1");
		c=getContentPane();
		c.setLayout(new FlowLayout());
		
		ct=0;
		
		b1=new JButton("Iguarl: ");
		// NOTA para cada butao tem quer ter essa estrutua so o content muda
		b1.addActionListener(this);
		c.add(b1);
		
		l1=new JLabel("Total de cliques: "+ct);
		l1.setForeground(Color.blue);
		c.add(l1);
		
		setSize(200,300);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ev)
	{
		ct++;
		l1.setText("Total de cliques: "+ct);
	}
	public static void main(String [] args)
	{
		Evento1_Listener e=new Evento1_Listener();
		e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		e.setLocationRelativeTo(null);
		e.setVisible(true);
	}

}
