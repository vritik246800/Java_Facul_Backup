import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginV3 extends JFrame
{
	private Container c;
	private JTextField t1;
	private JPasswordField t2;
	private JButton b1,b2;
	private JLabel l1,l2;
	
	public LoginV3()
	{
		super("LoginV3");
		
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
		
		 t2 = new JPasswordField(10);
	     c.add(t2);
		
		b1=new JButton("Entrar");
		b1.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
	                String user = t1.getText();
	                String pass = String.valueOf(t2.getPassword());
	                
	                if (user.equals("vritik") && pass.equals("2002"))
	                {
	                	RecargasV3 r = new RecargasV3();
	                    dispose();
	                }
	                else
	                {
	                    JOptionPane.showMessageDialog(null, "Nome do utilizador ou password incorreto. Tente novamente.");
	                    t1.setText("");
	                    t2.setText("");
	                }
				}
			}
		);
		c.add(b1);
		
		b2=new JButton("Sair");
		b2.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
					System.exit(0);
				}
			}
		);
		c.add(b2);
		
		setSize(250,200);
		setVisible(true);
	}
	public static void main(String [] args)
	{
		LoginV3 z=new LoginV3();
		z.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		z.setLocationRelativeTo(null);
	}

}
