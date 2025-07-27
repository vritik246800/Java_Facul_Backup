import java.awt.*;
import javax.swing.*;

public class CardLayoutDemo1 extends JFrame 
{
	private String []titulo=
	{
		"TAB1 button","TAB2 TextField","TAB3 radio B"	
	};
	private Container cont;
	private JTabbedPane tabs;
	private JPanel c1,c2,c3;
	
	public CardLayoutDemo1()
	{
		super("CardL com tabs");
		cont=getContentPane();
		
		tabs=new JTabbedPane();
		
		c1=new JPanel();
		c1.add(new JButton("Butao 1"));
		c1.add(new JButton("Butao 2"));
		c1.add(new JButton("Butao 3"));
		
		c2=new JPanel();
		c2.add(new JTextField("texte teste ",20));

		c3=new JPanel();
		c3.add(new JRadioButton("Radio 1",true));
		c3.add(new JRadioButton("Radio 1",false));
		
		tabs.addTab(titulo[0], c1);
		tabs.addTab(titulo[1], c2);
		tabs.addTab(titulo[2], c3);

		cont.add(tabs,BorderLayout.CENTER);
		
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[]args)
	{
		new CardLayoutDemo1();
	}

}
