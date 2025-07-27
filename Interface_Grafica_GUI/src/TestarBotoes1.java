import javax.swing.*;
import java.awt.*;

public class TestarBotoes1 extends JFrame
{
	private JButton b1,b2;
	private Container cont;
	
	public TestarBotoes1()
	{
		super("Testar Butao");
		cont=getContentPane();
		cont.setLayout(new FlowLayout());
		
		//criar butao
		
		b1=new JButton("butao 1 simples");
		cont.add(b1);
		
		Icon i1=new ImageIcon("img.jpg");
		Icon i2=new ImageIcon("img.jpg");
		b2=new JButton("butao 2 com imagem",i1);
		b2.setRolloverIcon(i2);
		cont.add(b2);
		
		setSize(1000,500);
		setVisible(true);
	}
	public static void main(String [] args)
	{
		TestarBotoes1 z=new TestarBotoes1();
		
		z.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
