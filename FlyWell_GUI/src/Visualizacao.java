import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Visualizacao extends JFrame
{
	private Container c;
	private JTable tabela;
	private String []cabeca= {"Destino","Passaport","Valor","Valor Final"};
	private String [][] dados;
	private JScrollPane scr;
	
	public Visualizacao(ArrayList a) 
	{
		super("Tabela de Visualizar todos");
		c=getContentPane();
		
		dados=preencherTab(a,a.size());
		tabela=new JTable(dados,cabeca);
		scr=new JScrollPane(tabela);
		tabela.setEnabled(false);
		
		c.add(scr);
		setSize(1000,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	public String [][]preencherTab(ArrayList a,int size)
	{
		Bilhete pai;
		String [][] s=new String [size][cabeca.length];
		
		for(int i=0;i<size;i++)
		{
			pai=(Bilhete)a.get(i);
			s[i][0]=pai.getdestino();
			s[i][1]=pai.getpassaport();
			s[i][2]=pai.getvalor()+"";
			s[i][3]=pai.vf()+"";
		}
		return s;
	}
	public void carroAntrigo(int poz)
	{
		
	}
}
