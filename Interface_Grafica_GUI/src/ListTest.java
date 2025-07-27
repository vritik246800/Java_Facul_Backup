import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;

public class ListTest extends JFrame 
{
	private JList colorList;
	private String colorName[]=
		{
			"Black","Blue","Cyan","Dark Gray","Gray","Green"
		};
	private Color colors[]=
		{
			Color.black,Color.blue,Color.darkGray,Color.gray,Color.green
		};
	private Container k;
	public ListTest()
	{
		k=getContentPane();
		k.setLayout(new FlowLayout());
		
		//cria uma list de itens 
		colorList=new JList(colorName);
		colorList.setVisibleRowCount(5);
		
		//nao permitir muitas cores
		colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		k.add(colorList);
		
		//config gestorde event
		colorList.addListSelectionListener
		(
			new ListSelectionListener()
			{
				public void valueChanged(ListSelectionEvent ev)
				{
					k.setBackground(colors[colorList.getSelectedIndex()]);
				}
			}
		);
		k.setBackground(new Color(255, 105, 180));
		setSize(350,150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	public static void main(String [] args)
	{
		new ListTest();
	}
}
