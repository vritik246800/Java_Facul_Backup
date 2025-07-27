import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Visualizacao extends JFrame 
{
	private Container c;
	private String coluna[]= 
	{
		"Numero de Apoles","Tipo de Seguro","Valor sem IVA","Valor com IVA"
	};
	private String dados[][];
	private JTable tab,tab1;
	private JScrollPane src,src1;
	
	public Visualizacao(ArrayList a)
	{
		super("Para Visualizar todos");
		c=getContentPane();
		
		dados=gerarTabela(a);
		
		tab=new JTable(dados,coluna);
		tab1=new JTable(dados,coluna);
		
		src=new JScrollPane(tab);
		//src1=
		//c.add(src,BorderLayout.CENTER);
		
		//c.revalidate();
	    //c.repaint();
		
	    JTabbedPane tabe=new JTabbedPane();
	    tabe.setBackground(Color.black);
	    tabe.setForeground(Color.pink);
	    
	    tabe.addTab("Seguro",src);
	    tabe.addTab("Nanila",new JScrollPane(tab1));
	    c.add(tabe);
	    
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	public String [][] gerarTabela(ArrayList a)
	{
		Seguro pai;
		String s[][]=new String[a.size()][coluna.length];
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Seguro)a.get(i);
			s[i][0]=pai.getnumeroA()+"";
			s[i][1]=pai.gettipoSeg();
			s[i][2]=pai.getvp()+"";
			s[i][3]=pai.vf()+"";
		}
		return s;
	}

	/*public void tabela(ArrayList a)
	{	
		dados=gerarTabela(a,a.size());
		tab=new JTable(dados,coluna);
		
		src=new JScrollPane(tab);
		c.add(src,BorderLayout.CENTER);
		
		c.revalidate();
	    c.repaint();
		
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}*/
}
