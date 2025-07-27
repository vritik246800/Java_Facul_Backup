import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CheckBoxTest extends JFrame
{ 
	private JTextField tf1;
	private JCheckBox bold, italic;
	private Container c;	
	
	// configura a GUI
	public CheckBoxTest()
	{
		super( "JCheckBox Test");
	
		c = getContentPane();
		setLayout(new FlowLayout());
		
		
		// configura JTextField e configura a fonte
		tf1 = new JTextField("Watch the font style change", 20);
		tf1.setFont(new Font("Serif", Font.PLAIN, 14));	
		c.add(tf1);
		//cria objectos de JCheckBox
		bold = new JCheckBox("Bold");
		c.add(bold);
		
		italic = new JCheckBox("Italic");
		c.add(italic);
		
		//registra listener para JCheckBox
		TrataEvento trat = new TrataEvento();
		bold.addItemListener(trat);
		italic.addItemListener(trat);
		
		setSize(275, 100);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args)
	{
		new CheckBoxTest();
	}
	//classe interna para tratmento de eventos
	private class TrataEvento implements ItemListener
	{
		private int valBold = Font.PLAIN;
		private int valItalic = Font.PLAIN;
		
		public void itemStateChanged(ItemEvent x)
		{
			// processa eventos da caixa bold
			if (x.getSource() == bold)
				if (x.getStateChange() == ItemEvent.SELECTED)
					valBold = Font.BOLD;
				else
					valBold = Font.PLAIN;
			//processa eventos da caixa italic
			if (x.getSource() == italic)
				if (x.getStateChange() == ItemEvent.SELECTED)
					valItalic = Font.ITALIC;
				else
					valItalic = Font.PLAIN;
			//configura a fonte do campo de texto para ambas caixas
			tf1.setFont(new Font("Serif", valBold + valItalic, 14));
		}
	}
}