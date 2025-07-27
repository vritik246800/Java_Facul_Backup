import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBox extends JFrame
{
	private JComboBox imagemCB;
	private JLabel l1;
	private String nome[]= 
	{
		"i1.gif","i2.gif","i3.gif","i4.gif"
	};
	private Icon icon[]= 
	{
		new ImageIcon(nome[0]),
		new ImageIcon(nome[1]),
		new ImageIcon(nome[2]),
		new ImageIcon(nome[3]),
	};
	private Container cont;
	
	public ComboBox()
	{
		super("teste de COMBOBOX");
		cont=getContentPane();
		cont.setLayout(new FlowLayout());
		
		imagemCB=new JComboBox(nome);
		imagemCB.setMaximumRowCount(3);
		imagemCB.addItemListener
		(
			new ItemListener()
			{
				public void itemStateChanged(ItemEvent ev)
				{
					if(ev.getStateChange()==ItemEvent.SELECTED)
						l1.setIcon(icon[imagemCB.getSelectedIndex()]);
				}
			}
		);
		cont.add(imagemCB);
		
		l1=new JLabel(icon[0]);
		cont.add(l1);
		
		setSize(350,150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	public static void main(String [] args)
	{
		new ComboBox();
	}
	
	

}
