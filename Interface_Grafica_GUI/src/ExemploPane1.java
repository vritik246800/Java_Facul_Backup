import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ExemploPane1 extends JFrame 
{
	private JPanel bp;
	private JButton b[];
	private Container c;
	
	public ExemploPane1()
	{
		super("teste de Panel :");
		c=getContentPane();
		
		//setUndecorated(true);
		
		bp = new JPanel();
		b=new JButton[5];
		bp.setLayout(new GridLayout(1,b.length));
		
		for(int i=0;i<b.length;i++)
		{
			b[i]=new JButton("Button"+(i));
			bp.add(b[i]);
		}
		c.add(bp,BorderLayout.SOUTH);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//c.setBackground(Color.LIGHT_GRAY);
		
	}
	
	
	public static void main(String[]args)
	{
		new ExemploPane1();
	}
}
