import javax.swing.*;
import java.awt.*;

public class TestFieldTest extends JFrame
{
	private JTextField t1,t2,t3;
	private JPasswordField t4;
	private Container cont;
	
	public TestFieldTest()
	{
		super("Testar JTextFiel e JPasswordField");
		
		cont=getContentPane();
		cont.setLayout(new FlowLayout());
		
		//campo de texto
		t1=new JTextField(10);
		//                |>  defenir a largura
		cont.add(t1);
		
		// campo de texto com tanho fix
		t2=new JTextField("Introduz texto aque");
		//                  |> defenir texto fixo
		cont.add(t2);
		
		// campo texto com tamanho fix e cumprimento
		t3=new JTextField("nao podes editar texto",20);
		t3.setEditable(false); // para nao ser possivel de editar
		cont.add(t3);
		
		// campo texto PIN
		t4=new JPasswordField("VRITIK",10);
		//                     |>
		cont.add(t4);
		
		setSize(1000,500);
		setVisible(true);
	}
	public static void main(String [] args)
	{
		TestFieldTest z=new TestFieldTest();
		
		z.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
