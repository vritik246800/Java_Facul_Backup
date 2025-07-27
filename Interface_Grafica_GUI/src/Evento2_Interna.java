// CLASS implenta Interna
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Evento2_Interna extends JFrame
{
	private JButton b1;
	private JLabel l1;
	private int ct=0;
	private Container c;
	
	public Evento2_Interna()
	{
		super("Evento_2");
		c=getContentPane();
		c.setLayout(new FlowLayout());
		
		ct=0;
		
		b1=new JButton("Iguarl: ");
		// NOTA para cada butao tem quer ter essa estrutua so o content muda
		Interna inter=new Interna();
		b1.addActionListener(inter);
		
		c.add(b1);
		
		l1=new JLabel("Total de cliques: "+ct);
		l1.setForeground(Color.blue);
		c.add(l1);
		
		setSize(200,300);
		setVisible(true);
		
	}
	private class Interna implements ActionListener
	{
		public void actionPerformed(ActionEvent ev)
		{
			ct++;
			l1.setText("Total de cliques: "+ct);
		}
	}
	public static void main(String [] args)
	{
		Evento2_Interna e=new Evento2_Interna();
		e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		e.setLocationRelativeTo(null);
		e.setVisible(true);
	}

}

