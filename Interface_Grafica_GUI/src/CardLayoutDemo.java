import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class CardLayoutDemo extends JFrame implements ItemListener
{
	private Container cont;
	private JPanel cards;
	private JPanel comboBoxPane;
	private String comboBoxItems[]= 
	{
		"Card com butao","card com JTextField","Card com Radio butto"
	};
	private JComboBox cb;
	private JPanel card1,card2,card3;
	
	public CardLayoutDemo()
	{
		super("teste de card Layout ");
		cont=getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cb=new JComboBox(comboBoxItems);
		comboBoxPane=new JPanel();
		cb.setEditable(false);
		cb.addItemListener(this);
		comboBoxPane.add(cb);
		
		card1=new JPanel();
		card1.add(new JButton("butao1"));
		card1.add(new JButton("butao2"));
		card1.add(new JButton("butao3"));
		
		card2=new JPanel();
		card2.add(new JTextField("textofield",20));
		
		card3=new JPanel();
		card3.add(new JRadioButton("Radio1 ",true));
		card3.add(new JRadioButton("Radio2 ",false));
		
		cards=new JPanel(new CardLayout());
		cards.add(card1,comboBoxItems[0]);
		cards.add(card2,comboBoxItems[1]);
		cards.add(card3,comboBoxItems[2]);
		
		cont.add(comboBoxPane,BorderLayout.NORTH);
		cont.add(cards,BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		// para reorganizacao das cartas
		pack();
		setVisible(true);
		
	}
	public void itemStateChanged(ItemEvent ev)
	{
		CardLayout cl=(CardLayout)(cards.getLayout());
		cl.show(cards,(String)ev.getItem());
	}
	public static void main(String[]args){ new CardLayoutDemo(); }
	
}
