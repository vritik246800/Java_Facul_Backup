import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.*;

public class JanelaVisualizacoes extends JFrame 
{
	private Container cont;
	private JTable tabela_agentes;
	private JScrollPane sp;
	private String [] cabecalho = {"Código","Nome do Agente","Tipo de Agente","Valor da comissão",
			"Cod Comerciante", "Valor Transação"};
	private String [][] dados;
	private DecimalFormat df;
	
	public JanelaVisualizacoes(Vector agentes) 
	{
		super("Visualização dos Pedidos");
		cont = getContentPane();
		df = new DecimalFormat("###,###.00Mts");
		dados = gerarTabela(agentes, agentes.size());
		tabela_agentes = new JTable(dados, cabecalho);
		tabela_agentes.setEnabled(false);
		sp = new JScrollPane(tabela_agentes);
		cont.add(sp, BorderLayout.CENTER);
		setSize(600,200);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public String[][] gerarTabela(Vector v, int linha) 
	{
		Agente a;
		AgenteComerciante ac;
		String [][] d = new String[linha][cabecalho.length];
	
		for (int i = 0; i < linha; i++) 
		{
			a = (Agente) v.elementAt(i);
			if(a instanceof AgenteComerciante) 
			{
				ac = (AgenteComerciante) a;
				d[i][0] = ac.getCodigo()+"";
				d[i][1] = ac.getNome();
				d[i][2] = ac.getTipoAgente()+"";
				d[i][3] = df.format(ac.getValorComissao());
				d[i][4] = ac.getCodComerciante()+"";
				d[i][5] = df.format(ac.getValTransacao());
			}
		}
		return d;
	}
}
