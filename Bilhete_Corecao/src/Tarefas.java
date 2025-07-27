import java.util.*;
import java.io.*;

public class Tarefas 
{
	private ArrayList bilhetes;
	private Visualizacoes vis;
	private FicheiroObjectos fobj;
	private Pesquisas pesq;
	private Remocoes rem;
	private Alteracoes alt;
	private Calculos cal;
	private Validacoes val;
	
	public Tarefas() 
	{
		bilhetes = new ArrayList();
		vis = new Visualizacoes();
		fobj = new FicheiroObjectos();
		pesq = new Pesquisas();
		rem = new Remocoes();
		alt = new Alteracoes();
		cal = new Calculos();
		val = new Validacoes();
	}

	public void lerFicheiro() 
	{
		StringTokenizer umaCadeia;
		String umaLinha, cod, nom, bi, datPart, datCheg, formPag, matricula, tipoComb, tipoMar, companhia;
		int valBilhete, valPortagem, qtdCombus, qtdMil;
		float numKM;
		char catBil, catTer;
		
		try 
		{
			FileReader fr = new FileReader("Dados.txt");
			BufferedReader br = new BufferedReader(fr);
			
			umaLinha = br.readLine();
			
			while(umaLinha != null) 
			{
				umaCadeia = new StringTokenizer(umaLinha, ";");
				cod = umaCadeia.nextToken();
				nom = umaCadeia.nextToken();
				bi = umaCadeia.nextToken();
				datPart = umaCadeia.nextToken();
				datCheg = umaCadeia.nextToken();
				valBilhete = Integer.parseInt(umaCadeia.nextToken());
				formPag = umaCadeia.nextToken();
				catBil = umaCadeia.nextToken().charAt(0);
				
				if(catBil == 'T' || catBil == 't') 
				{
					numKM = Float.parseFloat(umaCadeia.nextToken());
					catTer = umaCadeia.nextToken().charAt(0);
					
					if(catTer == 'V' || catTer == 'v') // V - viatura/carro
					{
						matricula = umaCadeia.nextToken();
						qtdCombus = Integer.parseInt(umaCadeia.nextToken());
						valPortagem = Integer.parseInt(umaCadeia.nextToken());
						criarObjCarro(cod,nom,bi,datPart,datCheg,formPag,valBilhete,numKM,matricula,qtdCombus,valPortagem);
					}
					
					else 
						if(catTer == 'C' || catTer == 'c') 
					    {
						  tipoComb = umaCadeia.nextToken();
						  criarObjComboio(cod,nom,bi,datPart,datCheg,formPag,valBilhete,tipoComb);
					    }
				}
				else 
				{
					if(catBil == 'A' || catBil == 'a') 
					{
						qtdMil = Integer.parseInt(umaCadeia.nextToken());
						companhia = umaCadeia.nextToken();
						criarObjAereo(cod,nom,bi,datPart,datCheg,formPag,valBilhete,qtdMil,companhia);
					}
					
					else 
						if(catBil == 'M' || catBil == 'm') 
					    {
						  tipoMar = umaCadeia.nextToken();
						  criarObjMar(cod,nom,bi,datPart,datCheg,formPag,valBilhete,tipoMar);
				     	}
				}
				umaLinha = br.readLine();
			}
			br.close();
			bilhetes.trimToSize();
			System.out.println("Ficheiro lido com sucesso!");
		} 
		catch (FileNotFoundException fe) { System.out.println("Ficheiro nao encontrado"); }
		catch(NumberFormatException ne) { System.out.println(ne.getMessage()); }
		catch(IOException io) { System.out.println(io.getMessage()); }
	}

	private void criarObjMar(String cod, String nom, String bi, String datPart, String datCheg, String formPag,
			int valBilhete, String tipoMar) 
	{
		Mar m = new Mar();
		m.setCodigo(cod);
		m.setNome(nom);
		m.setBi(bi);
		m.setDataPartida(datPart);
		m.setDataChegada(datCheg);
		m.setFormaPagamento(formPag);
		m.setValorBilhete(valBilhete);
		m.setTipo(tipoMar);
		
		bilhetes.add(m);
	}

	private void criarObjAereo(String cod, String nom, String bi, String datPart, String datCheg, String formPag,
			int valBilhete, int qtdMil, String companhia) 
	{
		Aereo a = new Aereo();
		a.setCodigo(cod);
		a.setNome(nom);
		a.setBi(bi);
		a.setDataPartida(datPart);
		a.setDataChegada(datCheg);
		a.setFormaPagamento(formPag);
		a.setValorBilhete(valBilhete);
		a.setQtdMilhas(qtdMil);
		a.setCompanhiaAerea(companhia);
		
		bilhetes.add(a);
	}

	private void criarObjComboio(String cod, String nom, String bi, String datPart, String datCheg, String formPag,
			int valBilhete, String tipoComb) 
	{
		Comboio c = new Comboio();
		c.setCodigo(cod);
		c.setNome(nom);
		c.setBi(bi);
		c.setDataPartida(datPart);
		c.setDataChegada(datCheg);
		c.setFormaPagamento(formPag);
		c.setValorBilhete(valBilhete);
		c.setTipo(tipoComb);
		
		bilhetes.add(c);	
	}

	private void criarObjCarro(String codigo, String nome, String bi, String dataPartida, String dataChegada, String formaPagamento,
			int valorBilhete, float numKilometros, String matricula, float qtdCombustivel, int valorPortagem) 
	{
		Carro c = new Carro();
		c.setCodigo(codigo);
		c.setNome(nome);
		c.setBi(bi);
		c.setDataPartida(dataPartida);
		c.setDataChegada(dataChegada);
		c.setFormaPagamento(formaPagamento);
		c.setValorBilhete(valorBilhete);
		c.setNumKilometros(numKilometros);
		c.setMatricula(matricula);
		c.setQtdCombustivel(qtdCombustivel);
		c.setValorPortagem(valorPortagem);
		
		bilhetes.add(c);
	}
	
	
	public String toString() 
	{
		return vis.visualizarTodosBilhetes(bilhetes);
	}
	
	public void adaptQuantidadeBilhetesTipo() 
	{
		vis.visualizarQuantidades();
	}
	
	public void adaptEscritaFichObj() 
	{
		fobj.escreverFichObj(bilhetes);
	}
	
	public void adaptLeituraFichObj() 
	{
		fobj.lerFichObj(bilhetes);
	}
	
	public void adaptPesquisarBilheteCodigo() 
	{
		String cod = val.validarString("Introduza o codigo do bilhete que deseja pesquisar");
		int i = pesq.pesquisarBilhetePorCodigo(bilhetes, cod);
		vis.visualizarBilhetePesquisado(bilhetes, i);
	}
	
	public void adaptRemoverBilheteCodigo() 
	{
		String cod = val.validarString("Introduza o codigo do bilhete que deseja remover");
		int i = pesq.pesquisarBilhetePorCodigo(bilhetes, cod);
		rem.removerPorCodigo(bilhetes, i);
	}
	
	public void adaptAlterarMilhasCodigo() 
	{
		String codigo = val.validarString("Introduza o codigo do bilhete aereo que deseja alterar");
		int i = pesq.pesquisarBilheteAereoPorCodigo(bilhetes, codigo);
		if(i == -1)
			System.out.println("Bilhete nao foi encontrado!");
		else 
		{
			int milhas = val.validarInt("Introduza a nova quantidade de milhas (>0)");
			alt.alterarMilhas(bilhetes, i, milhas);
		}
	}
	
	public void adaptCalcularValTotalRecebido() 
	{
		float valT = cal.calcularValorTotal(bilhetes);
		vis.visualizarValorTotal(valT);
	}
	
	public void adaptVisualizarVooMaisLongo() 
	{
		int indMaior = pesq.pesquisarVooMaisLongo(bilhetes);
		vis.visualizarVooMaisLongo(bilhetes, indMaior);
	}
}
