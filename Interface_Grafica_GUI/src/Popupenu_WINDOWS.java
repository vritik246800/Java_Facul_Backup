import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Popupenu_WINDOWS extends JFrame 
{
	private Container cont;
	
	private JPopupMenu pop;
	private JMenuItem item1,item2;
	
	public Popupenu_WINDOWS()
	{
		super("teste de rigth click para (WINDOWS)");
		cont=getContentPane();
		cont.addMouseListener
		(
			new MouseAdapter()
			{
				public void mouseReleased(MouseEvent e)
				{
					processMouseEvent(e);
				}
				public void processMouseEvent(MouseEvent e)
				{
					if(e.isPopupTrigger())
						pop.show(e.getComponent(),e.getX(),e.getY());
				}
			}
		);
		
		pop=new JPopupMenu();
		
		item1=new JMenuItem("OP1");
		item2=new JMenuItem("OP2");
		
		pop.add(item1);
		pop.add(item2);
		
		
		setLocationRelativeTo(null);
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	public static void main (String[]args)
	{
		new Popupenu_WINDOWS();
	}

}
