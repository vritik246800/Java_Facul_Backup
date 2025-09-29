import java.awt.*;
import java.io.*;
import javax.swing.*;

public class TodosNotas extends JFrame
{
	private Container cont;
	private JMenuBar bar;
	private JMenu file;
	private JMenuItem save,open,novo,exit;
	private JTextArea area;
	
	public TodosNotas() 
	{
		// Configurações do Menu
		super("NotePad");
		cont=getContentPane();
		cont.setLayout(new BorderLayout());
		// Menu
		bar=new JMenuBar();
		setJMenuBar(bar);
		// Menu File
		file=new JMenu("File");

		// Savar Nota
		save=new JMenuItem("Save");
		save.addActionListener
		(
			e->{
				String conteudo=area.getText();
				Nota nota=new Nota(conteudo);
				String nomeFile=JOptionPane.showInputDialog("Digite o nome do Documento:");
				
				// Criar pasta Data se não existir
				File dataDir = new File("../Data");
				if (!dataDir.exists()) 
					dataDir.mkdir();
				
				// Salvar arquivo
				File file=new File("../Data/"+nomeFile+".txt");
				
				if(conteudo.isEmpty())
				{
					JOptionPane.showMessageDialog(this, "Conteúdo vazio! Nada a salvar.");
					return;
				}
				if(nomeFile==null || nomeFile.trim().isEmpty())
				{
					JOptionPane.showMessageDialog(this, "Nome de arquivo precica!");
					return;
				}
				try(FileWriter fr=new FileWriter(file))
				{
					fr.write(conteudo);
					fr.close();
					JOptionPane.showMessageDialog(this, "Arquivo salvo em Data/" + nomeFile + ".txt");
				} 
				catch (IOException ex)
				{
					JOptionPane.showMessageDialog(this, "Erro ao salvar arquivo!");
				}
			}
		);
		file.add(save);
		open=new JMenuItem("Open");
		file.add(open);
		novo=new JMenuItem("New");
		file.add(novo);
		exit=new JMenuItem("Exit");
		exit.addActionListener(e->System.exit(0));
		file.add(exit);

		bar.add(file);
		

		// Define o ícone da janela
		setIconImage(new ImageIcon("../Image/iconNote1.png").getImage());




		// Area de Texto
		area=new JTextArea();
		JScrollPane scroll=new JScrollPane(area);
		cont.add(scroll,BorderLayout.CENTER);

		// Configurações da Janela
		setLocationRelativeTo(null);
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
}
