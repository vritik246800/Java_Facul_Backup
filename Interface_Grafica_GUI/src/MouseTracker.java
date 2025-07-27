import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MouseTracker extends JFrame implements MouseListener,MouseMotionListener
{ 
	private JLabel statusBar;
	public MouseTracker()
	{ 
		super("Demonstrating Mouse Events");
		statusBar = new JLabel();
		getContentPane().add(statusBar, BorderLayout.SOUTH);
		addMouseListener(this);
		setLocationRelativeTo(null);
		addMouseMotionListener(this);
		setSize(1000, 500);
		setVisible(true);
	}
//implementação de métodos do MouseListener, processa o evento quando mouse
//é largado immediatamente apos de ser pressionado
	public void mouseClicked(MouseEvent event )
	{
		statusBar.setText("Clicked at ["+event.getX()+", "+event.getY()+"]" ); 
	}
//processa o evento quando mouse é pressionado
	public void mousePressed( MouseEvent event )
	{
		statusBar.setText( "Pressed at ["+event.getX()+", "+event.getY()+"]"); 
	}
//processa o evento quando mouse é largado apos de ser arrastado
	public void mouseReleased(MouseEvent event )
	{ 
		statusBar.setText("Released at ["+event.getX()+", " +event.getY() + "]" ); 
	}
	//processa o evento quando mouse entra em uma área
	public void mouseEntered(MouseEvent event )
	{
		JOptionPane.showMessageDialog(null, "Mouse in window" ); 
	}
	//processa o evento quando mouse entra sai de uma área
	public void mouseExited(MouseEvent event)
	{
		statusBar.setText("Mouse outside window"); 
	}
	//implementação de métodos do MouseMotionListener
	//processa o evento quando mouse é arrastado com o botão pressionado
	public void mouseDragged( MouseEvent event )
	{
		statusBar.setText("Dragged at [" +event.getX()+", "+event.getY()+"]" ); 
	}
	//processa o evento quando mouse é movimentado
	public void mouseMoved( MouseEvent event )
	{
		statusBar.setText("Moved at [" + event.getX()+", "+event.getY()+"]"); 
	}
	public static void main(String args[] )
	{
		MouseTracker application = new MouseTracker();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}