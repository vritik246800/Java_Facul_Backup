import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class JanelaPrincipal extends JFrame
{
	private Container cont;
	private JMenuBar bar;
	
	private JMenu ficheiro, dados, visualizacoes, tarefas;
	private JMenuItem lerFicheiro, sair, novoRegisto, comerciantes, escreverFicheiro, 
	totalComissoes, alteracoes;
	private Vector agentes;
	private DecimalFormat df;
	
	public JanelaPrincipal() 
	{
		super("Agentes TMcel");
		cont = getContentPane();
		bar = new JMenuBar();
		setJMenuBar(bar);
		
		agentes = new Vector();
		df = new DecimalFormat("###,###.00Mts");

		//menus
		
		//ficheiro
		ficheiro = new JMenu("Ficheiro");
		ficheiro.setMnemonic('F');
		lerFicheiro = new JMenuItem("Ler Ficheiro de Texto");
		lerFicheiro.setMnemonic('L');
		lerFicheiro.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				lerDoFicheiroTexto();
			}
		});
		ficheiro.add(lerFicheiro);
		
		sair = new JMenuItem("Sair");
		sair.setMnemonic('S');
		sair.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		
		ficheiro.add(sair);
		
		//dados
		dados = new JMenu("Dados");
		dados.setMnemonic('D');
		novoRegisto = new JMenuItem("Registar Agente");
		novoRegisto.setMnemonic('R');
		novoRegisto.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new JanelaNovoAgente(agentes);
			}
		});
		dados.add(novoRegisto);
		
		escreverFicheiro = new JMenuItem("Quantidades");
		escreverFicheiro.setMnemonic('N');
		escreverFicheiro.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ev) 
			{
				EscritaFicheiro ef = new EscritaFicheiro(); 
				ef.escreverQuantidadesTxt();
			}
		});
		dados.add(escreverFicheiro);
		dados.addSeparator();
		tarefas = new JMenu("Tarefas");
			
		alteracoes = new JMenuItem("Alterar Agente");
		alteracoes.setMnemonic('A');
		alteracoes.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev) 
			{
				Pesquisas pes = new Pesquisas();
				Alteracoes alt = new Alteracoes();
				int cod = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduza o Agente vendedor que deseja alterar:"));
				int i = pes.pesquisarPorCodigo(agentes, cod);
				alt.alterarVendedor(agentes, i);
			}
		});
		tarefas.addSeparator();
		tarefas.add(alteracoes);
		dados.add(tarefas);
		tarefas.setMnemonic('F');
		
		//visualizacoes
		visualizacoes = new JMenu("Visualizacoes");
		visualizacoes.setMnemonic('V');
		comerciantes = new JMenuItem("Todos Comerciantes");
		comerciantes.setMnemonic('C');
		comerciantes.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new JanelaVisualizacoes(agentes);
			}
		});
		visualizacoes.add(comerciantes);
		
		totalComissoes = new JMenuItem("Total Comissoes");
		totalComissoes.setMnemonic('M');
		totalComissoes.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Calculos cal = new Calculos();
				float v = cal.calcularValorTotalComissoes(agentes);
				JOptionPane.showMessageDialog(null, "Valor Total Comissoes:"+df.format(v));
			}
		});
		visualizacoes.add(totalComissoes);
		
		bar.add(ficheiro);
		bar.add(dados);
		bar.add(visualizacoes);
		
		setJMenuBar(bar);
		setSize(400,200);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	//leitura do ficheiro do texto e armazenamento no vector
	public void lerDoFicheiroTexto() 
	{
		StringTokenizer umaCadeia;
		byte numReg, numRec, valRec;
		int cod, codCom, valTrans;
		String umaLinha, nom;
		float vCom;
		char tipCart, tipAg;
		
		try 
		{
			FileReader fr = new FileReader("Agentes.txt");
			BufferedReader br = new BufferedReader(fr);
			
			umaLinha = br.readLine();
			
			while(umaLinha != null) 
			{
				umaCadeia = new StringTokenizer(umaLinha, ";");
				cod = Integer.parseInt(umaCadeia.nextToken());
				nom = umaCadeia.nextToken();
				tipAg = umaCadeia.nextToken().charAt(0);
				vCom = Float.parseFloat(umaCadeia.nextToken());
				
				switch(tipAg) 
				{
					case 'R': 	tipCart = umaCadeia.nextToken().charAt(0);
								numReg = Byte.parseByte(umaCadeia.nextToken());
								criarObjectoRegisto(cod,nom,tipAg,vCom,tipCart,numReg);
								break;
					case 'C': 	codCom = Integer.parseInt(umaCadeia.nextToken());
								valTrans = Integer.parseInt(umaCadeia.nextToken());
								criarObjectoComerciante(cod,nom,tipAg,vCom,codCom,valTrans);
								break;
					case 'V':	numRec = Byte.parseByte(umaCadeia.nextToken());
								valRec = Byte.parseByte(umaCadeia.nextToken());
								criarObjectoVendedor(cod,nom,tipAg,vCom,numRec,valRec);
								break;
				}
				
				umaLinha = br.readLine();
			}
			br.close();
			JOptionPane.showMessageDialog(null, "Dados lidos do ficheiro de texto com sucesso");
		}
		
		catch(FileNotFoundException fexp) {JOptionPane.showMessageDialog(null, "Ficheiro nao encontrado!");}
		catch(NumberFormatException nexp) {JOptionPane.showMessageDialog(null, nexp.getMessage());}
		catch(IOException io) {JOptionPane.showMessageDialog(null, io.getMessage());}		
	}
	
	private void criarObjectoVendedor(int cod, String nom, char tipAg, float vCom, byte numRec, byte valRec) {
		AgenteVendedor av = new AgenteVendedor();
		av.setCodigo(cod);
		av.setNome(nom);
		av.setTipoAgente(tipAg);
		av.setValorComissao(vCom);
		av.setNumVendas(numRec);
		av.setValRecarga(valRec);
		
		agentes.add(av);
		agentes.trimToSize();
	}

	private void criarObjectoComerciante(int cod, String nom, char tipAg, float vCom, int codCom, int valTrans) {
		AgenteComerciante ac = new AgenteComerciante();
		ac.setCodigo(cod);
		ac.setNome(nom);
		ac.setTipoAgente(tipAg);
		ac.setValorComissao(vCom);
		ac.setCodComerciante(codCom);
		ac.setValTransacao(valTrans);
		
		agentes.add(ac);
		agentes.trimToSize();
		
	}

	private void criarObjectoRegisto(int cod, String nom, char tipAg, float vCom, char tipCart, byte numReg) {
		AgenteRegisto ar = new AgenteRegisto();
		ar.setCodigo(cod);
		ar.setNome(nom);
		ar.setTipoAgente(tipAg);
		ar.setValorComissao(vCom);
		ar.setTipoRegisto(tipCart);
		ar.setNumRegistos(numReg);
		
		agentes.add(ar);
		agentes.trimToSize();
		
	}

	public static void main(String[] args) {
		new JanelaPrincipal();
	}
}
