import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonTest extends JFrame 
{
	private JTextField field;
	private Font plainFont, boldFont,italicFont,boldItalicFont;
	private JRadioButton boldItalicButton,plainButton,boldbutton,italicButton;
	private ButtonGroup radioGroup;
	private Container cont;
	
	//criar GUI e fonte
	public RadioButtonTest()
	{
		super("RadioButton Test");
		cont=getContentPane();
		cont.setLayout(new FlowLayout());
		
		field=new JTextField("Ve ja o texto a mudar !",25);
		cont.add(field);
		
		//criar botoes de opcao
		plainButton=new JRadioButton("Plain",true);
		cont.add(plainButton);
		
		boldbutton=new JRadioButton("Bold",false);
		cont.add(boldbutton);
		
		italicButton=new JRadioButton("Italic",false);
		cont.add(italicButton);
		
		boldItalicButton=new JRadioButton("Bold",false);
		cont.add(boldItalicButton);
		
		//registar eventos para JRadioButton
		TratarEvento x=new TratarEvento();
		plainButton.addItemListener(x);
		boldbutton.addItemListener(x);
		italicButton.addItemListener(x);
		boldItalicButton.addItemListener(x);
		
		//criar relacionamento logico entre JRadioButton
		radioGroup=new ButtonGroup();
		radioGroup.add(plainButton);
		radioGroup.add(boldbutton);
		radioGroup.add(italicButton);
		radioGroup.add(boldItalicButton);
		
		//cria OBJ Font
		plainFont=new Font("Serif",Font.PLAIN,14);
		boldFont=new Font("Serif",Font.BOLD,14);
		italicFont=new Font("Serif",Font.ITALIC,14);
		boldItalicFont=new Font("Serif",Font.BOLD+Font.ITALIC,14);
		
		field.setFont(plainFont);
		setSize(300,100);
		setVisible(true);	
	}
	public static void main(String [] args)
	{
		RadioButtonTest r=new RadioButtonTest();
		r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		r.setLocationRelativeTo(null);
	}
	
	//classs envento
	public class TratarEvento implements ItemListener
	{
		public void itemStateChanged(ItemEvent evt)
		{
			if(evt.getSource()==plainButton)
				field.setFont(plainFont);
			else if(evt.getSource()==boldbutton)
				field.setFont(boldFont);
			else if(evt.getSource()==italicButton)
				field.setFont(italicFont);
			else if(evt.getSource()==boldItalicButton)
				field.setFont(boldItalicFont);		
		}
	}
}
