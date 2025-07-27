import javax.swing.*;
import java.awt.*;

public class Login extends JFrame
{
	private Container c;
	private JTextField t1,t2;
	private JButton b1,b2;
	private JLabel l1,l2;
	
	public Login()
	{
		super("Login");
		
		c=getContentPane();
		c.setLayout(new FlowLayout());
		
		l1=new JLabel("Utilizador: ");
		l1.setToolTipText("Introduz o nome do utilizador ");
		c.add(l1);
		
		t1=new JTextField(10);
		c.add(t1);
		
		l2=new JLabel("Password: ");
		l2.setToolTipText("Introduz a password ");
		c.add(l2);
		
		t2=new JPasswordField(10);
		c.add(t2);
		
		b1=new JButton("Entrar");
		c.add(b1);
		
		b2=new JButton("Sair");
		c.add(b2);
		
		setSize(250,200);
		setVisible(true);
	}
	public static void main(String [] args)
	{
		Login z=new Login();
		z.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		z.setLocationRelativeTo(null);
	}

}
