import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;	
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

//ler do file sempre no menu
//ter ArrayList

public class JanelaPrincipal extends JFrame
{
	//private boolean valN=false;
	private Container c;
	private File file;
	private JMenuBar bar;
	private JMenu ficheiro,operacoes,visualizacoes,tarefas;
	private JMenuItem remover,calculo,exit,novoSeg,lerFile,writeObj,todosSeg;
	private ArrayList a;
	private DecimalFormat m;
	private Visualizacao vis;
	private Calculo cal;
	private AbrirFinder af;
	private ImageIcon imagem;
	private JLabel wallpaper;
	private Pesquisa pes;
	private Validar val;
	
	
	
	public JanelaPrincipal()
	{
		super("Hollard Seguros");
		c=getContentPane();
		c.setLayout(new FlowLayout());
		
		//falta classes
		file=new File();
		m=new DecimalFormat("###,###,###.00 Mts");
		a=new ArrayList();
		//vis=new Visualizacao();
		cal=new Calculo();
		af=new AbrirFinder();
		pes=new Pesquisa();
		val=new Validar();
		
		
		imagem = new ImageIcon("icon.png");
		wallpaper=new JLabel(imagem);
		c.add(wallpaper);
		c.setBackground(Color.LIGHT_GRAY);
		
		bar=new JMenuBar();
		setJMenuBar(bar);
		
		ficheiro=new JMenu("Ficheiro");
		
		lerFile=new JMenuItem("Ler do File");
		lerFile.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
					lerFile();
					//valN=true;
				}
			}
		);
		
		exit=new JMenuItem("Exit");
		//exit.setMnemonic('x');
		
		ficheiro.add(lerFile);
		
		exit.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
					System.exit(0);
					//dispose();
				}
			}
		);
		ficheiro.add(exit);
		bar.add(ficheiro);
		
		
		operacoes=new JMenu("Operacoes");
		novoSeg=new JMenuItem("Novo Seguro");
		/*if(valN==false)
		{
			JOptionPane.showMessageDialog(null,"Primeiro executa o opcao de ler de ficherio");
		}
		else
		{*/
			novoSeg.addActionListener
			(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent ev)
					{
						new GuiRegistar(a);
					}
				}
			);
		//}
		
		operacoes.add(novoSeg);
		
		writeObj=new JMenuItem("Write Object");
		writeObj.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
					file.writeObj(a);
				}
			}
		);
		operacoes.add(writeObj);
		
		
		
		bar.add(operacoes);
		
		
		visualizacoes=new JMenu("Visualizacoes");
		
		todosSeg=new JMenuItem("Todos Seguros");
		todosSeg.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
					//vis.tabela(a);
					new Visualizacao(a);
				}
			}
		);
		
		visualizacoes.add(todosSeg);
		
		tarefas=new JMenu("Tarefas");
		visualizacoes.add(tarefas);
		
		remover=new JMenuItem("Remover");
		remover.addActionListener
		(
			new ActionListener()
			{
				int numeroA,poz;
				
				public void actionPerformed(ActionEvent ev)
				{
					numeroA=Integer.parseInt(val.validarNumeroA());
					poz=pes.pesquisaNumeroA(a, numeroA);
					if(poz==-1)
						JOptionPane.showMessageDialog(null,"O numero de apoles nao existe !");
					else
					{
						JOptionPane.showMessageDialog(null,"Removido com sucesso !");
						a.remove(poz);
						//vis.atualizarTabela(a);
						
					}
				}
			}
		);
		tarefas.add(remover);
		
		calculo=new JMenuItem("Calculo");
		calculo.addActionListener
		(
			new ActionListener()
			{
				float acum;
				public void actionPerformed(ActionEvent ev)
				{
					acum=cal.acumulador(a);
					JOptionPane.showMessageDialog(null,"O valor total recebido pela Hollard Seguros sao: "+m.format(acum));
				}
			}
		);
		tarefas.add(calculo);
		
		visualizacoes.add(tarefas);
		
		bar.setBackground(Color.BLACK);
		bar.setForeground(Color.blue);
		bar.add(visualizacoes);
		//c.repaint();
		
		
		
		
		
		setSize(1000,500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void lerFile()
	{
		
		int numeroA;
		String tipoSeg,linha;
		float vp;
		StringTokenizer seccao;
		
		try
		{
			FileReader fr=new FileReader("Dados.txt");
			BufferedReader br=new BufferedReader(fr);
			
			linha=br.readLine();
			while(linha!=null)
			{
				seccao=new StringTokenizer(linha,";");
				
				numeroA=Integer.parseInt(seccao.nextToken());
				tipoSeg=seccao.nextToken();
				vp=Float.parseFloat(seccao.nextToken());
				
				obj(tipoSeg,numeroA,vp);				
				
				linha=br.readLine();
			}
			br.close();
			a.trimToSize();
			JOptionPane.showMessageDialog(null,"O file.txt lido com sucesso!!!");
			
		}
		catch(FileNotFoundException fn)
		{
			System.out.println("Nao encontra file.txt");
			JOptionPane.showMessageDialog(null,"Nao encontra file.txt");
		}
		catch(NumberFormatException nf)
		{
			JOptionPane.showMessageDialog(null,nf.getMessage());
		}
		catch(IOException io)
		{
			JOptionPane.showMessageDialog(null, io.getMessage());
		}
	}
	public void obj(String tipoSeg,int numeroA,float vp)
	{
		Seguro s=new Seguro();
		
		s.settipoSeg(tipoSeg);
		s.setnumeroA(numeroA);
		s.setvp(vp);
		
		a.add(s);
	}
	public static void main(String[]args)
	{
		new JanelaPrincipal();
	}

}
