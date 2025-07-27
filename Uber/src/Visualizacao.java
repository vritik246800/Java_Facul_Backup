import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.*;

public class Visualizacao extends JFrame 
{
	private JTable tab;
	private String[][] dados;
	private String [] top=
	{
		"Nome do Cliente","Tipo de Viatura","Quantidade de Passageiro","Valor a pagar"
	};
	private Container c;
	private JScrollPane roll;
	private DecimalFormat m;
	
	public Visualizacao(ArrayList list)
	{
		super("Tabela de Viz");
		c=getContentPane();
		//c.setLayout(new FlowLayout());
		
		m=new DecimalFormat("###,###,###.00 Mts");
		
		dados=criarTabel(list.size(),list);
		tab=new JTable(dados,top);
		roll=new JScrollPane(tab);
		c.add(roll);
		
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public String [][] criarTabel(int tamanholist,ArrayList list)
	{
		String t[][]=new String [tamanholist][top.length];
		Cliente pai;
		
		for(int i=0;i<list.size();i++)
		{
			pai=(Cliente)list.get(i);
			t[i][0]=pai.getnome();
			t[i][1]=pai.gettpC();
			t[i][2]=pai.getqtyP()+"";
			t[i][3]=m.format(pai.calculo());
		}
		return t;
	}
	
}
