import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class BorderlayoutDemo extends JFrame 
{
	private JButton button[];
	private String names[]=
		{
			"Hide North","HideSouth","Hide East","Hide West","Hide Center"
		};
	private BorderLayout lt;
	
	public BorderlayoutDemo()
	{
		super("Teste de border Layout");
		lt=new BorderLayout(5,5);
		Container con= getContentPane();
		con.setLayout(lt);
		//con.setBackground(Color.ORANGE);
		button=new JButton[names.length];
		
		TrataEv x=new TrataEv();
		for(int i=0;i<names.length;i++)
		{
			button[i]=new JButton(names[i]);
			button[i].addActionListener(x);
		}
		con.add(button[0],BorderLayout.NORTH);
		con.add(button[1],BorderLayout.SOUTH);
		con.add(button[2],BorderLayout.EAST);
		con.add(button[3],BorderLayout.WEST);
		con.add(button[4],BorderLayout.CENTER);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//con.setBackground(Color.ORANGE);
		//con.setBackground(Color.TRANSLUCENT);
		//con.setBackground(Color.OPAQUE);
		con.setBackground(Color.ORANGE);
		
		
	}
	private class TrataEv implements ActionListener
	{
		public void actionPerformed(ActionEvent ev)
		{
			for(int i=0;i<button.length;i++)
			{
				if(ev.getSource()==button[i])
					button[i].setVisible(false);
				else
					button[i].setVisible(true);
				lt.layoutContainer(getContentPane());
			}
		}
	}
	
	public static void main(String[]args)
	{
		new BorderlayoutDemo();
	}

}
