import java.util.*;
import java.io.*;

public class TodosIndividuos //extends Comparable <Individuo>
{
	private ArvoreBinaria lista;
	private Visualizacoes vis;
	
	
	public TodosIndividuos()
	{
		//list=ArvoreBinaria();
		lista = new ArvoreBinaria();
		vis = new Visualizacoes();
	}
	
	/*public void lerDados()
	{
		//Atributos do individuo
		String nome, genero, nacionalidade, bI,endereco,numTelefone;
		int idade;
		//Atributos da vitima 
		String estadoFisico, tipoDano, relatorioVitima, atendimentoMedico;
		//Atributos do suspeito
		String antecedentes, grauPericulosidade, estadoDetensao, depoimento, advogadoPresente;
		String dados, criterio;
		StringTokenizer umaCadeia;
		try
		{
			BufferedReader ler = new BufferedReader(new FileReader("dados.txt"));
			dados=ler.readLine();
			while(dados!=null)
			{
				umaCadeia = new StringTokenizer(dados,";");
				nome=umaCadeia.nextToken();
				idade=Integer.parseInt(umaCadeia.nextToken());
				genero=umaCadeia.nextToken();
				nacionalidade = umaCadeia.nextToken();
				bI=umaCadeia.nextToken();
				endereco=umaCadeia.nextToken();
				numTelefone = umaCadeia.nextToken();
				criterio=umaCadeia.nextToken();
				if(criterio.equals("VV"))
				{
					estadoFisico=umaCadeia.nextToken();
					tipoDano=umaCadeia.nextToken();
					relatorioVitima=umaCadeia.nextToken();
					atendimentoMedico=umaCadeia.nextToken();
					criarVitima(nome, idade, genero, nacionalidade, bI, endereco, numTelefone, estadoFisico, tipoDano, relatorioVitima, atendimentoMedico);
				}
				else
				{
					if(criterio.equals("SS"))
					{
						antecedentes = umaCadeia.nextToken();
						grauPericulosidade = umaCadeia.nextToken();
						estadoDetensao=umaCadeia.nextToken();
						depoimento=umaCadeia.nextToken();
						advogadoPresente =umaCadeia.nextToken();
						criarSuspeito(nome, idade, genero, nacionalidade, bI, endereco, numTelefone,antecedentes, grauPericulosidade, estadoDetensao, depoimento, advogadoPresente);
					}
				}
				dados=ler.readLine();
			}
			//lista.trimToSize();
			System.out.println("File lido com sucesso!");
			ler.close();
		}
		catch(FileNotFoundException f) {System.out.println("Ficheiro de texto nao encontrado! (Certifique-se de que esta criado)");}
		catch(NumberFormatException n) {System.out.println(n.getMessage());}
		catch(IOException i) {System.out.println(i.getMessage());}
	}*/
	public void lerDados() {
	    // Atributos do individuo
	    String nome, genero, nacionalidade, bI, endereco, numTelefone;
	    int idade;
	    // Atributos da vitima
	    String estadoFisico, tipoDano, relatorioVitima, atendimentoMedico;
	    // Atributos do suspeito
	    String antecedentes, grauPericulosidade, estadoDetensao, depoimento, advogadoPresente;
	    String dados, criterio;
	    StringTokenizer umaCadeia;
	    try {
	        BufferedReader ler = new BufferedReader(new FileReader("dados.txt"));
	        dados = ler.readLine();
	        while (dados != null) {
	            umaCadeia = new StringTokenizer(dados, ";");
	            nome = umaCadeia.nextToken();
	            idade = Integer.parseInt(umaCadeia.nextToken());
	            genero = umaCadeia.nextToken();
	            nacionalidade = umaCadeia.nextToken();
	            bI = umaCadeia.nextToken();
	            endereco = umaCadeia.nextToken();
	            numTelefone = umaCadeia.nextToken();
	            criterio = umaCadeia.nextToken();
	            if (criterio.equals("VV")) {
	                estadoFisico = umaCadeia.nextToken();
	                tipoDano = umaCadeia.nextToken();
	                relatorioVitima = umaCadeia.nextToken();
	                atendimentoMedico = umaCadeia.nextToken();
	                criarVitima(nome, idade, genero, nacionalidade, bI, endereco, numTelefone, estadoFisico, tipoDano, relatorioVitima, atendimentoMedico);
	            } else {
	                if (criterio.equals("SS")) {
	                    antecedentes = umaCadeia.nextToken();
	                    grauPericulosidade = umaCadeia.nextToken();
	                    estadoDetensao = umaCadeia.nextToken();
	                    depoimento = umaCadeia.nextToken();
	                    advogadoPresente = umaCadeia.nextToken();
	                    criarSuspeito(nome, idade, genero, nacionalidade, bI, endereco, numTelefone, antecedentes, grauPericulosidade, estadoDetensao, depoimento, advogadoPresente);
	                }
	            }
	            dados = ler.readLine();
	        }
	        System.out.println("File lido com sucesso!");
	        ler.close();
	    } catch (FileNotFoundException f) {
	        System.out.println("Ficheiro de texto nao encontrado! (Certifique-se de que esta criado)");
	    } catch (NumberFormatException n) {
	        System.out.println(n.getMessage());
	    } catch (IOException i) {
	        System.out.println(i.getMessage());
	    }
	}
	public void criarSuspeito( String nome, int idade, String genero, String nacionalidade, String bI, String endereco, String numTelefone, String antecedentes, String grauPericulosidade, String estadoDetensao, String depoimento, String advogadoPresente)
	{
		Suspeito s = new Suspeito();
		s.setAdvogadoPresente(advogadoPresente);
		s.setAntecedentesCriminais(antecedentes);
		s.setDepoimento(depoimento);
		s.setEndereco(endereco);
		s.setEstadoDetensao(estadoDetensao);
		s.setGenero(genero);
		s.setGrauPericulosidade(grauPericulosidade);
		s.setIdade(idade);
		s.setNacionalidade(nacionalidade);
		s.setNome(nome);
		s.setNumeroBI(bI);
		s.setNumTelefone(numTelefone);
		lista.inserir(s);
	}
	public void criarVitima( String nome, int idade, String genero, String nacionalidade, String bI, String endereco, String numTelefone, String estadoFisico, String tipoDano, String relatorioVitima, String atendimentoMedico)
	{
		Vitima v = new Vitima();
		v.setAtendimenteMedico(atendimentoMedico);
		v.setEndereco(endereco);
		v.setEstadoFisico(estadoFisico);
		v.setGenero(genero);
		v.setIdade(idade);
		v.setNacionalidade(nacionalidade);
		v.setNome(nome);
		v.setNumeroBI(bI);
		v.setNumTelefone(numTelefone);
		v.setRelatorioVitima(relatorioVitima);
		v.setTipoDano(tipoDano);
		lista.inserir(v);
	}
	public void novaDenucia()
	{
		System.out.println("|=====================|DADOS DA VITIMA|=====================|");
		Vitima vitima = new Vitima("Nova");
		lista.inserir(vitima);
		System.out.println("|=====================|DADOS DO SUSPEITO|=====================|");
		Suspeito suspeito = new Suspeito("Novo");
		lista.inserir(suspeito);
	}
	public void adaptarVerTodosDados() {
	    vis.verTodosDados(lista);
	}
}
