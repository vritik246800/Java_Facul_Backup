// ----- INÍCIO DO ARQUIVO TabelaArrayListGUI.java -----
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class TabelaArrayListGUI extends JFrame
{
	private Container c;
	private JTable tab;
	private JScrollPane scrl;
	private String titulo[]=
	{
		"Artigo","Quantidade","Preco","Total"
	};
	private String [][] tabDados; // Boa prática: String[][] tabDados;
	private TabelaOBJ pai;
	private ArrayList a; // Boa prática: dar um nome mais descritivo, ex: ArrayList<TabelaOBJ> listaDeObjetos;

	//constract
	public TabelaArrayListGUI()
	{
		super("TEste de tabela");
		a=new ArrayList(); // Considere tipar: a = new ArrayList<TabelaOBJ>();
		lerDoFichTxt();

		tabDados=criarTabela();
		tab=new JTable(tabDados,titulo);

		scrl=new JScrollPane(tab);

		c=getContentPane();

		c.add(scrl,BorderLayout.CENTER); // Esta era a linha 32 problemática

		setVisible(true);
		setLocationRelativeTo(null);
		setSize(300,200);
		c.setBackground(Color.LIGHT_GRAY); // 'c' já está inicializado aqui, o que é bom
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void lerDoFichTxt()
	{
		// Seria melhor mostrar esta mensagem DEPOIS que o arquivo for lido com sucesso.
		// JOptionPane.showMessageDialog(TabelaArrayListGUI.this,"File lido com sucesso\nClica OK para aparecer Tabelas! ; }", "OK",JOptionPane.PLAIN_MESSAGE);
		StringTokenizer seccao;
		String linha,artigo,nomeFich="Dados.txt"; // Presume-se que "Dados.txt" existe e tem o formato esperado
		int qty;
		float preco;
		try
		{
			FileReader fr=new FileReader(nomeFich);
			BufferedReader br=new BufferedReader(fr);
			linha=br.readLine();
			while(linha!=null)
			{
				seccao=new StringTokenizer(linha,";");

				artigo=seccao.nextToken();
				qty=Integer.parseInt(seccao.nextToken());
				preco=Float.parseFloat(seccao.nextToken());

				oBj(artigo,qty,preco);


				linha=br.readLine();
			}
			a.trimToSize();
			br.close();
            // Mostrar mensagem de sucesso aqui seria mais apropriado
            JOptionPane.showMessageDialog(TabelaArrayListGUI.this,"Arquivo '" + nomeFich + "' lido com sucesso!\nClique OK para ver a tabela.", "Leitura Concluída",JOptionPane.INFORMATION_MESSAGE);

		}
		catch(FileNotFoundException fn)
		{
			// System.out.println("File nao encontraa"); // Melhor usar JOptionPane para GUI
            JOptionPane.showMessageDialog(TabelaArrayListGUI.this, "Arquivo '" + nomeFich + "' não encontrado!", "Erro de Arquivo", JOptionPane.ERROR_MESSAGE);
		}
		catch(NumberFormatException nf)
		{
			// System.out.println(nf.getMessage());
            JOptionPane.showMessageDialog(TabelaArrayListGUI.this, "Erro ao converter número no arquivo: " + nf.getMessage(), "Erro de Formato", JOptionPane.ERROR_MESSAGE);
		}
		catch(NoSuchElementException nse) {
            JOptionPane.showMessageDialog(TabelaArrayListGUI.this, "Erro de formatação no arquivo: Faltam tokens na linha.\n" + nse.getMessage(), "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        }
		catch(IOException io)
		{
			// System.out.println(io.getMessage());
            JOptionPane.showMessageDialog(TabelaArrayListGUI.this, "Erro de E/S ao ler o arquivo: " + io.getMessage(), "Erro de Leitura", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void oBj(String artigo,int qty,float preco)
	{
		TabelaOBJ t=new TabelaOBJ();
		t.setArtigo(artigo);
		t.setQty(qty);
		t.setPreco(preco);
		a.add(t);
	}
	public String [][] criarTabela()
	{
		String x[][]=new String[a.size()][titulo.length]; // Boa prática: String[][] x = ...

		for(int i=0;i<a.size();i++)
		{
			pai=(TabelaOBJ)a.get(i); // Se 'a' for tipado com <TabelaOBJ>, o cast não é necessário
			x[i][0]=pai.getArtigo();
			x[i][1]=pai.getQty()+"";
			x[i][2]=pai.getPreco()+"";
			x[i][3]=String.valueOf(pai.getQty()*pai.getPreco()); // Melhor usar String.valueOf() para conversão
		}
		return x;
	}
	public static void main(String []args)
	{
		// É uma boa prática executar código Swing na Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TabelaArrayListGUI();
            }
        });
	}
}
// ----- FIM DO ARQUIVO TabelaArrayListGUI.java -----