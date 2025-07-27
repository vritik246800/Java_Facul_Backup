import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class GuiRegistar extends JFrame 
{
	private JLabel numeroL,tipoSegL,valorL;
	private JTextField numeroT,valorT;
	private JRadioButton trb,arb,vrb;
	private JButton safe,exit;
	private ButtonGroup grup;
	private JList teste;
	private JPanel seccao;
	private Container c;
	
	public GuiRegistar(ArrayList a)
	{
		super("Novo Seguro");
		c=getContentPane();
		c.setLayout(new GridLayout(4,2));
		c.setBackground(Color.LIGHT_GRAY);
		
		teste=
		
		numeroL=new JLabel("Numero da Apolice:");
		numeroL.setToolTipText("Introduz numero Inteiro (>0)");
		c.add(numeroL);
		
		numeroT=new JTextField(22);
		c.add(numeroT);
		
		tipoSegL=new JLabel("Tipo de Seguro:");
		tipoSegL.setToolTipText("Seliciona um das 3 opcoes ");
		c.add(tipoSegL);
		
		seccao=new JPanel(new GridLayout(1,3));
		
		trb=new JRadioButton("Trabalho",true);
		arb=new JRadioButton("Acidente",false);
		vrb=new JRadioButton("Vida",false);
		
		grup=new ButtonGroup();
		grup.add(trb);
		grup.add(arb);
		grup.add(vrb);
		
		seccao.add(trb);
		seccao.add(arb);
		seccao.add(vrb);
		
		c.add(seccao);
		
		valorL=new JLabel("Valor do Seguro:");
		valorL.setToolTipText("Introduz o valor do seguro");
		c.add(valorL);
		
		valorT=new JTextField(22);
		c.add(valorT);
		
		safe=new JButton("Gravar");
		c.add(safe);
		safe.addActionListener
		(
			new ActionListener()
			{
				int numeroA;
				String tipoSeg;
				float valorP;
				public void actionPerformed(ActionEvent ev)
				{
					numeroA=Integer.parseInt(numeroT.getText());
					if(trb.isSelected())
						tipoSeg=trb.getText();
					else if(arb.isSelected())
						tipoSeg=arb.getText();
					else if(vrb.isSelected())
						tipoSeg=vrb.getText();
					valorP=Float.parseFloat(valorT.getText());
					array(a,tipoSeg,numeroA,valorP);
					JOptionPane.showMessageDialog(null,"Novo Cliente Criard com Sucesso !");
				}
			}
		);
		
		
		exit=new JButton("Sair");
		c.add(exit);
		exit.addActionListener
		(		
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
					dispose();
				}
			}
		);
		setSize(700,300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void array(ArrayList a,String tipoSeg,int numeroA,float valorP)
	{
		Seguro c=new Seguro();
		c.settipoSeg(tipoSeg);
		c.setnumeroA(numeroA);
		c.setvp(valorP);
		
		limparCampo();
		
		a.add(c);
		a.trimToSize();
	}
	public void limparCampo()
	{
		numeroT.setText("");
		grup.clearSelection();
		valorT.setText("");
	}

}
