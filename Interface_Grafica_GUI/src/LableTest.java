import java.awt.*;
import javax.swing.*;
public class LableTest extends JFrame
{
	private JLabel label1,label2,label3;
	private Container cont;
	
	// config GUI
	public LableTest(String str)
	{
		super(str);
		
		cont=getContentPane(); // para obter janela de conteudo
		cont.setLayout(new FlowLayout()); 
		// |> para dizer os dados aparecer comecar da direita para esquerda
		
		// construtor JLable com um argumento do tipo String
		label1=new JLabel("Label com texto");
		label1.setToolTipText("insto e 1-o  rotulo");
		cont.add(label1);
		//|> pra adicionar o label na janela
		
		Icon bug=new ImageIcon("img.jpg");
		// declarar imagem
		
		// construtor JLabel com 3 parametro
		label2=new JLabel("Label com text e imagem(Icon)",bug,SwingConstants.LEFT);
		label2.setToolTipText("insto e 2-o rotulo");
		cont.add(label2);
		
		// construtor JLabel sem String
		label3=new JLabel();
		label3.setText("Label com ICON e text em baixo");
		label3.setIcon(bug);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setFont(new Font("Serif",Font.BOLD | Font.ITALIC,16));
		label3.setForeground(Color.blue);
		label3.setToolTipText("Isto e 3-o rotulo");
		cont.add(label3);
		
		setSize(1000,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String [] args)
	{
		new LableTest("Testando JLabel");
	}

}




