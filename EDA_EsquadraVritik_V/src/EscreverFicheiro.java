import java.util.*;
import java.io.*;
public class EscreverFicheiro 
{
	public EscreverFicheiro()
	{
		
	}
	public void escreverVitima(String nome,int idade,String genero,String nacionalidade,String numeroBI,String endereco,String numTelefone,String estadoFisico,String tipoDano,String relatorioVitima,String atendimentoMedico)
	{
		try
		{
			BufferedWriter e = new BufferedWriter(new FileWriter("dados.txt",true));
			e.newLine();
			e.write(nome+";"+idade+";"+genero+";"+nacionalidade+";"+numeroBI+";"+endereco+";"+numTelefone+";"+"VV"+";"+estadoFisico+";"+tipoDano+";"+relatorioVitima+";"+atendimentoMedico);
			e.close();
		}
		catch(IOException i) {System.out.println(i.getMessage());};
	}
	public void escreverSuspeito(String nome, int idade, String genero, String nacionalidade, String numeroBI,String endereco,String numTelefone,String grauPericulosidade,String antecedentesCriminais,String estadoDetensao,String depoimento,String advogadoPresente)
	{
		try
		{
			BufferedWriter e = new BufferedWriter(new FileWriter("dados.txt",true));
			e.newLine();
			e.write(nome+";"+idade+";"+genero+";"+nacionalidade+";"+numeroBI+";"+endereco+";"+numTelefone+";"+"SS"+";"+grauPericulosidade+";"+antecedentesCriminais+";"+estadoDetensao+";"+depoimento+";"+advogadoPresente);
			e.close();
		}
		catch(IOException i) {System.out.println(i.getMessage());};
	}
}
