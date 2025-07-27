import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginV2 extends JFrame
{
    private Container c;
    private JTextField t1;
    private JPasswordField t2;
    private JButton b1, b2;
    private JLabel l1, l2;
    
    public LoginV2()
    {
        super("LoginV2");
        
        c = getContentPane();
        c.setLayout(new FlowLayout());
        //setLayout(new BorderLayout());
        setSize(250, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        l1 = new JLabel("Utilizador: ");
        l1.setToolTipText("Introduz o nome do utilizador");
        c.add(l1);
        
        t1 = new JTextField(10);
        c.add(t1);
        
        l2 = new JLabel("Password: ");
        l2.setToolTipText("Introduz a password");
        c.add(l2);
        
        t2 = new JPasswordField(10);
        c.add(t2);
        
        Interna in = new Interna();
        
        b1 = new JButton("Entrar");
        b1.addActionListener(in);
        c.add(b1);
        
        b2 = new JButton("Sair");
        b2.addActionListener(in);
        c.add(b2);
        
       
    }
    
    public class Interna implements ActionListener
    {
        public void actionPerformed(ActionEvent ev)
        {
            if (ev.getSource() == b2)
            {
                System.exit(0);
            }
            else if (ev.getSource() == b1)
            {
                String user = t1.getText();
                String pass = String.valueOf(t2.getPassword());
                
                if (user.equals("vritik") && pass.equals("2002"))
                {
                    Recargas r = new Recargas();
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
    }
    
    public static void main(String[] args)
    {
        LoginV2 z=new LoginV2();
		z.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		z.setLocationRelativeTo(null);
    }
}
