import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class FlyWell_GUI extends JFrame 
{
	
	private JMenuBar bar;
	private JMenu ficheiro,operacoes,tarefas;
	private JMenuItem about,lerFile,sair,todosBilhete,alterarL,carromais,escreverfile;
	private Container obj;
	private JPanel pane;
	private ArrayList a;
	private Visualizacao vis;
	private Pesquisa pes;
	private Alteracoes alt;
	private Calculo cal;
	private File file;
	
	public FlyWell_GUI()
	{
		super ("FlyWell");
		//bl=new BorderLayout(5,5);
		obj=getContentPane();
		//c.setLayout(bl);
		
		bar=new JMenuBar();
		setJMenuBar(bar);
		a=new ArrayList();
		pes=new Pesquisa();
		alt=new Alteracoes();
		cal=new Calculo();
		file=new File();
		
		
		ficheiro=new JMenu("Ficheiro");
		ficheiro.setMnemonic('i');
		
		lerFile=new JMenuItem("Ler do Ficheiro");
		lerFile.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
					lerFile();
					operacoes.setEnabled(true);
				}
			}
		);
		ficheiro.add(lerFile);
		lerFile.setMnemonic('f');
		sair=new JMenuItem("Sair");
		sair.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
					System.exit(0);
				}
			}
		);
		about=new JMenuItem("About");
		about.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
					JOptionPane.showMessageDialog(null,"Nome do Programador: \nVritik Valabdas\nCode:\n20190025","Aluno Isctem",JOptionPane.ERROR_MESSAGE);
				}
			}
		);
		ficheiro.add(about);
		ficheiro.add(sair);
		
		
		
		bar.add(ficheiro);
		
		operacoes=new JMenu("Operacoes");
		
		todosBilhete=new JMenuItem("Todos Bilhetes");
		
		operacoes.setEnabled(false);
		
		todosBilhete.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
					vis=new Visualizacao(a);
				}
			}
		);
		operacoes.add(todosBilhete);
		alterarL=new JMenuItem("Alterar Lotacao");
		alterarL.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
					String nomeBarco=JOptionPane.showInputDialog("Introduz o nome do barco");
					int poz=pes.pesquisa(a,nomeBarco);
					if(poz==-1)
						JOptionPane.showMessageDialog(null,"O nome de barco nao existe");
					else
					{
						int lotacao=Integer.parseInt(JOptionPane.showInputDialog("Introduz o numero de lotacao"));
						alt.alterar(a,poz,lotacao);
						JOptionPane.showMessageDialog(null,"A lotacao trocado com sucesso: "+lotacao);
					}
				}
			}
		);
		operacoes.add(alterarL);
		operacoes.addSeparator();
		
		tarefas=new JMenu("Tarefas");
		operacoes.add(tarefas);
		carromais=new JMenuItem("Carro Mais Antigo");
		carromais.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
					//String matricula=JOptionPane.showInputDialog("Introduz a matricula: ");
					int poz=pes.pesquisamatricula(a);
					if(poz==-1)
						JOptionPane.showMessageDialog(null,"A matricula de carro nao existe");
					else
					{
						Bilhete pai;
						BilheteCarro car;
						
						pai=(Bilhete)a.get(poz);
						if(pai instanceof BilheteCarro)
						{
							car=(BilheteCarro)pai;
							JOptionPane.showMessageDialog(null,"O carro mais antigo de matricula e:\n"+car.getmatricula()+"\nE a marca e:\n"+car.getmarca());
						}
					}
				}
			}
		);
		tarefas.add(carromais);
		escreverfile=new JMenuItem("Escrever no Ficheiro");
		escreverfile.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
					float acum=cal.acumulador(a);
					file.write(acum);
					JOptionPane.showMessageDialog(null,"O file do valor total ja foi criado como | Acumulador.txt |");
				}
			}
		);
		tarefas.add(escreverfile);
		
		bar.add(operacoes);
		obj.setBackground(Color.gray);
		
		//pane=new JPanel(new GridLayout(2,1,5,5));
		//pane.add(bar);
		
		//c.add(pane,BorderLayout.WEST);
		
		setSize(1000,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void lerFile()
	{
		String linha,nome,tipo,destino,passaport,companhiaAerea,matricula,marca;
		int valor,anoFabrico,lotacao;
		char criterio;
		StringTokenizer st;
		
		try
		{
			FileReader fr=new FileReader("Dados.txt");
			BufferedReader br=new BufferedReader(fr);
			
			linha=br.readLine();
			while(linha!=null)
			{
				st=new StringTokenizer(linha,";");
				destino=st.nextToken();
				passaport=st.nextToken();
				valor=Integer.parseInt(st.nextToken());
				criterio=(st.nextToken()).charAt(0);
				switch(criterio)
				{
					case 'A': case 'a':
						companhiaAerea=st.nextToken();
						oA(destino,passaport,valor,companhiaAerea);
						break;
					case 'B': case 'b':
						nome=st.nextToken();
						tipo=st.nextToken();
						lotacao=Integer.parseInt(st.nextToken());
						oB(destino,passaport,valor,nome,tipo,lotacao);
						break;
					case 'C': case 'c':
						matricula=st.nextToken();
						marca=st.nextToken();
						anoFabrico=Integer.parseInt(st.nextToken());
						oC(destino,passaport,valor,matricula,marca,anoFabrico);
						break;
					default:
						JOptionPane.showMessageDialog(null,"Esse tipo de bilhete nao existe !");
				}
				linha=br.readLine();
			}
			br.close();
			a.trimToSize();
		}
		catch(FileNotFoundException fn)
		{
			JOptionPane.showMessageDialog(null,"File.txt nao encontra");
		}
		catch(NumberFormatException nf)
		{
			JOptionPane.showMessageDialog(null,nf.getMessage());
		}
		catch(IOException io)
		{
			JOptionPane.showMessageDialog(null,io.getMessage());
		}
		JOptionPane.showMessageDialog(null,"File lido com sucesso !");
	}
	public void oC(String destino,String passaport,int valor,String matricula,String marca,int anoFabrico)
	{
		BilheteCarro obj=new BilheteCarro();
		
		obj.setdestino(destino);
		obj.setpassaport(passaport);
		obj.setvalor(valor);
		obj.setmarca(marca);
		obj.setanoFabrico(anoFabrico);
		
		a.add(obj);
	}
	public void oB(String destino,String passaport,int valor,String nome,String tipo,int lotacao)
	{
		BilheteBarco obj=new BilheteBarco();
		
		obj.setdestino(destino);
		obj.setpassaport(passaport);
		obj.setvalor(valor);
		obj.setnome(nome);
		obj.settipo(tipo);
		obj.setlotacao(lotacao);
		
		a.add(obj);
	}
	public void oA(String destino,String passaport,int valor,String companhiaAerea)
	{
		BilheteAereo obj=new BilheteAereo();
		
		obj.setdestino(destino);
		obj.setpassaport(passaport);
		obj.setvalor(valor);
		obj.setcompanhiaAerea(companhiaAerea);
		
		a.add(obj);
	}
	public static void main(String[]args)
	{
		new FlyWell_GUI();
	}

}
