import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class TodosNotas extends JFrame
{
	private Container cont;
	private JMenuBar bar;
	private JMenu file;
	private JMenuItem save,saveas,open,novo,exit;
	private JTextArea area;
	private JFileChooser fileChooser;

	private File nomeFile;
	private static String nomeDoc="novoDocumento";
	
	
	public TodosNotas() 
	{
		// Configurações do Menu
		super("NotePad - "+nomeDoc);
		cont=getContentPane();
		cont.setLayout(new BorderLayout());
		// Menu
		bar=new JMenuBar();
		setJMenuBar(bar);
		// Menu File
		file=new JMenu("File");
		file.setToolTipText("Arquivo (alt+F)");
		file.setMnemonic('F');

		

		// Savar como
		saveas=new JMenuItem("Save As");
		saveas.setToolTipText("Salvar o arquivo com nome e local desejado (alt+S)");
		saveas.setMnemonic('S');
		//saveas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		saveas.addActionListener
		(
			e->{
				String conteudo=area.getText();
				
				// Abrir JFileChooser para selecionar local de salvamento
				fileChooser = new JFileChooser();
				fileChooser.setSelectedFile(new File(nomeDoc)); // Nome padrão do arquivo
				int userSelection = fileChooser.showSaveDialog(this);
				if (userSelection == JFileChooser.APPROVE_OPTION) 
				{
					File fileToSave = fileChooser.getSelectedFile();
					nomeDoc = fileToSave.getName();
					setTitle("NotePad - "+nomeDoc);
					// Salvar o conteúdo no arquivo selecionado
					if(conteudo.isEmpty())
					{
						JOptionPane.showMessageDialog(this, "Conteúdo vazio! Nada a salvar.");
						return;
					}
					// valida se o nome do arquivo tem extensão
					if(!nomeDoc.contains("."))
					{
						JOptionPane.showMessageDialog(this, "Nome de arquivo precisa de extensão!");
						return;
					}
					try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) 
					{
						writer.write(area.getText());
						JOptionPane.showMessageDialog(this, "Arquivo salvo com sucesso: " + fileToSave.getAbsolutePath());
					} 
					catch (IOException ex) 
					{
						JOptionPane.showMessageDialog(this, "Erro ao salvar arquivo!");	
					}
				}
			}
		);
		file.add(saveas);
		// Salvar
		save=new JMenuItem("Save");
		save.setToolTipText("Salvar normalmente o arquivo (ctrl+S)");
		//save.setMnemonic('S');
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		save.addActionListener
		(
			e->{
				nomeFile = fileChooser.getSelectedFile();
				nomeDoc=nomeFile.getName();
				setTitle("NotePad - "+nomeDoc);
				String conteudo=area.getText();
				 // Se o arquivo já foi salvo antes
				if (nomeFile != null) 
				{ // nomeFile é um File de instância da sua classe
					try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeFile))) {
						writer.write(conteudo);
						JOptionPane.showMessageDialog(this, "Arquivo salvo com sucesso: " + nomeFile.getAbsolutePath());
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(this, "Erro ao salvar arquivo!");
					}
				}
				// Se não tiver sido salvo antes, chamar o "Salvar Como"
				else 
					saveas.doClick();
				
			}
		);
		file.add(save);
		// Abrir Nota
		open=new JMenuItem("Open");
		open.setMnemonic('O');
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		open.setToolTipText("Abrir um ficheiro existente ([alt|ctrl]+O)");
		open.addActionListener
		(
			e->{
				fileChooser = new JFileChooser("~");
				int result = fileChooser.showOpenDialog(this);
				// Se o usuário selecionar um arquivo
				if (result == JFileChooser.APPROVE_OPTION) 
				{
					// Lê o arquivo selecionado
					File selectedFile = fileChooser.getSelectedFile();
					nomeDoc = fileChooser.getSelectedFile().getAbsolutePath();
					setTitle("NotePad - "+nomeDoc);
					// Exibe o conteúdo na área de texto
					try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) 
					{
						area.setText("");
						String line;
						while ((line = br.readLine()) != null) 
						{
							area.append(line + "\n");
						}
					} 
					catch (IOException ex) 
					{
						JOptionPane.showMessageDialog(this, "Erro ao abrir arquivo!");
					}
				}
			}
		);
		file.add(open);
		// Nova Nota
		novo=new JMenuItem("New");
		file.add(novo);
		novo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		novo.setToolTipText("Criar uma nova nota (ctrl+N)");
		novo.addActionListener
		(
			e->{
				area.setText("");
				nomeDoc="novoDocumento";
				setTitle("NotePad - "+nomeDoc);
			}
		);
		// Sair do NotePad
		exit=new JMenuItem("Exit");
		exit.setToolTipText("Sair do NotePad (alt/+X | alt+F4)");
		exit.setMnemonic('X');
		//pergutar se quer mesmo sair sim ou não
		exit.addActionListener
		(
			e->
			{
				JOptionPane optionPane=new JOptionPane("Deseja mesmo sair do NotePad?",JOptionPane.QUESTION_MESSAGE,JOptionPane.YES_NO_OPTION);
				JDialog dialog=optionPane.createDialog("Sair do NotePad");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				Object selectedValue=optionPane.getValue();
				if(selectedValue!=null && (int)selectedValue==JOptionPane.YES_OPTION)
					System.exit(0);

			}
		);
		file.add(exit);

		bar.add(file);
		

		// Define o ícone da janela
		setIconImage(new ImageIcon("../Image/iconNote1.png").getImage());

		// Area de Texto
		area=new JTextArea();
		JScrollPane scroll=new JScrollPane(area);
		cont.add(scroll,BorderLayout.CENTER);

		// Configurações da Janela
				// Look and Feel
				try 
				{
					// Look and Feel do Sistema Operativo
						//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					// Look and Feel Nimbus
						UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					// Look and Feel Metal (padrão Java)	
						//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					// Look and Feel CDE/Motif (antigo sistema Unix)
						//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
					// Look and Feel CrossPlatform (padrão Java independente do sistema)
						//UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

					SwingUtilities.updateComponentTreeUI(this);
				} 
				catch (Exception e) 
				{
					System.out.println("Erro ao definir Look and Feel: " + e.getMessage());
				}
			// Dar a posição da janela no centro do ecrã ou definir a posição
				setLocationRelativeTo(null);
				//setLocation(100, 100);
			
			setSize(800,600);
			setVisible(true);
			// configurações para fechar a janela com sim ou nao ao clicar no X
				//setDefaultCloseOperation(EXIT_ON_CLOSE);
				addWindowListener
				(
					new WindowAdapter() 
					{
						public void windowClosing(WindowEvent e) 
						{
							if (JOptionPane.showConfirmDialog(null,"Gostaria de sair do programa?","Confirmação de Saída",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
								System.exit(0);
							else
								setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
						}
					}
				);
	}
	void main()
	{
		new TodosNotas();
	}
}
