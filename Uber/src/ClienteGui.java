import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class ClienteGui extends JFrame
{
	private Visualizacao vis;
	private Container cont;
	private JLabel nomel,passageirol,tipoVl,clienteCTl,ctl;
	private JTextField nomet;
	private JButton saveb,vizb;
	private JRadioButton tipoVRB1,tipoVRB2;
	private ButtonGroup grup;
	private JComboBox passageiroCB;
	private GridLayout grid;
	private JPanel pane;
	private ArrayList list;
	private Cliente pai;
	private String numero []=
	{
		"1","2","3","4","5"
	};
	//combobox so aceita String por isso
	
	
	public ClienteGui()
	{
		super("Uber");
		grid=new GridLayout(5,2);
		
		cont=getContentPane();
		cont.setLayout(grid);
		
		list=new ArrayList();
		
		nomel=new JLabel("Nome do Cliente:");
		nomel.setToolTipText("Introduz o nome do cliente");
		cont.add(nomel);
		
		nomet=new JTextField(22);
		cont.add(nomet);
		
		passageirol=new JLabel("Passageiros: ");
		passageirol.setToolTipText("Escolhe a quantidade de passageiro de (1-5)");
		cont.add(passageirol);
		
		passageiroCB=new JComboBox(numero);
		passageiroCB.setMaximumRowCount(3);
		
		//para fazer add de qualquer item no e add no JComboBox
		cont.add(passageiroCB);
		
		tipoVl=new JLabel("Tipo de Viaturas:");
		tipoVl.setToolTipText("Seleciona as duas opcoes que exite !");
		cont.add(tipoVl);
		
		pane=new JPanel();
		TratarEv t=new TratarEv();
		
		tipoVRB1=new JRadioButton("Normal",true);
		tipoVRB2=new JRadioButton("Executivo",false);
		
		grup=new ButtonGroup();
		grup.add(tipoVRB1);
		grup.add(tipoVRB2);
		
		pane.setLayout(new GridLayout(1,2));
		pane.add(tipoVRB1);
		pane.add(tipoVRB2);
		cont.add(pane);
		
		tipoVRB1.addActionListener(t);
		tipoVRB2.addActionListener(t);
		
		clienteCTl=new JLabel("Clientes");
		clienteCTl.setToolTipText("O contador de clientes");
		cont.add(clienteCTl);
		
		ctl=new JLabel(Cliente.ctC+"");
		cont.add(ctl);
		
		saveb=new JButton("Gravar");
		saveb.setBackground(Color.black);
		saveb.setForeground(Color.blue);
		cont.add(saveb);
		saveb.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					String nome,tpC="",vp;
					int qtyP;
					
					nome=nomet.getText();
					//VALIDAR espaco sem nome
					if(nome.isEmpty())
						JOptionPane.showMessageDialog(null,"Nao pode gravar sem o nome");
					
					nome=nomet.getText();
					//outra forma de ter texto usando Radio Button
					if(tipoVRB1.isSelected())
						tpC="Normal";
					else if(tipoVRB2.isSelected())
						tpC=tipoVRB2.getText();
					
					qtyP=Integer.parseInt(numero[passageiroCB.getSelectedIndex()]);
					
					array(nome,tpC,qtyP);
					ctl.setText(Cliente.ctC+"");
				}
			}
		);
		
		vizb=new JButton("Visualizar");
		vizb.setBackground(Color.black);
		vizb.setForeground(Color.blue);
		/*vizb.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					String s="";
					
					for(int i=0;i<list.size();i++)
					{
						pai=(Cliente)list.get(i);
						s+=pai.toString()+"\n";
					}
					JOptionPane.showMessageDialog(null,s);
				}
			}
		);*/
		vizb.addActionListener
		(
			new ActionListener()
			{
				
				public void actionPerformed(ActionEvent ev)
				{
					new Visualizacao(list);
					dispose();
				}
			}
		);
		
		cont.add(vizb);
		
		//touch de background
		//cont.setBackground(Color.LIGHT_GRAY);
		//butao e  action listener
		//radio e combobox e item listener
		//cont.setBack
		
		setSize(500,300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private class TratarEv implements ActionListener
	{
		String teste;
		int qtyP;
		
		public void actionPerformed(ActionEvent ev)
		{
			if(ev.getSource()==tipoVRB1)
			{
				tipoVRB1.setForeground(Color.red);
				tipoVRB2.setForeground(Color.black);
				teste=tipoVRB1.getText();
			}
			else if(ev.getSource()==tipoVRB2)
			{
				tipoVRB2.setForeground(Color.red);
				tipoVRB1.setForeground(Color.black);
				teste=tipoVRB2.getText();
			}
			JOptionPane.showMessageDialog(null, teste);
		}
	}
	public void array(String nome,String tpC,int qtyP)
	{
		Cliente c=new Cliente();
		
		c.setnome(nome);
		c.settpC(tpC);
		c.setqtyP(qtyP);
		
		list.add(c);
		list.trimToSize();
	}
	

}
