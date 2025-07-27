import java.util.*;
import java.io.*;
public class EscreverFicheiro 
{
	public EscreverFicheiro()
	{
		
	}
	public void escreverVitima(String nome,int idade,String genero,String nacionalidade,String numeroBI,String endereco,String numTelefone,String estadoFisico,String tipoDano,String relatorioVitima,String atendimentoMedico, int numeroPessoas, String data, String hora)
	{
		try
		{
			BufferedWriter e = new BufferedWriter(new FileWriter("dados.txt",true));
			e.newLine();
			e.write(nome+";"+idade+";"+genero+";"+nacionalidade+";"+numeroBI+";"+endereco+";"+numTelefone+";"+"V"+";"+estadoFisico+";"+tipoDano+";"+relatorioVitima+";"+atendimentoMedico+";"+numeroPessoas+";"+data+";"+hora);
			e.close();
		}
		catch(IOException i) {System.out.println(i.getMessage());};
	}
	public void escreverSuspeito(String nome, int idade, String genero, String nacionalidade, String numeroBI,String endereco,String numTelefone,String grauPericulosidade,String antecedentesCriminais,String estadoDetensao,String depoimento,String advogadoPresente, int numeroPessoas, String data, String hora)
	{
		try
		{
			BufferedWriter e = new BufferedWriter(new FileWriter("dados.txt",true));
			e.newLine();
			e.write(nome+";"+idade+";"+genero+";"+nacionalidade+";"+numeroBI+";"+endereco+";"+numTelefone+";"+"S"+";"+grauPericulosidade+";"+antecedentesCriminais+";"+estadoDetensao+";"+depoimento+";"+advogadoPresente+";"+numeroPessoas+";"+data+";"+hora);
			e.close();
		}
		catch(IOException i) {System.out.println(i.getMessage());};
	}
}
