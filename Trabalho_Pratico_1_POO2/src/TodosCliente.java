import java.util.*;
import java.io.*;

public class TodosCliente 
{
	private ArrayList a;
	private Visualizar vis;
	private Ficheiro fi;
	private Calculos cal;
	private Pesquisa pes;
	private Validar val;

	public TodosCliente()
	{
		a=new ArrayList();
		vis=new Visualizar();
		fi=new Ficheiro();
		cal=new Calculos();
		pes=new Pesquisa();
		val=new Validar();
		
	}
	public void todos()
	{
		StringTokenizer st;
		String linha,numeroTelefone,nomeCliente,dataCompra,estadoCompra,marcaViatura,modeloViatura,dataCDoutoramento,nomeIGovernal,incluirManutencao,nomeComercial,tipoViatura,estrangeiro;
		int qtyViaturas,numeroAnosForaPais,codeViatura,cilindragem,precoViatura;
		char c;
		
		try
		{
			FileReader fr=new FileReader("Dados.txt");
			BufferedReader br=new BufferedReader(fr);
			
			linha=br.readLine();
			while(linha!=null)
			{
				st=new StringTokenizer(linha,";");
				
				numeroTelefone=st.nextToken();
				nomeCliente=st.nextToken();
				dataCompra=st.nextToken();
				estadoCompra=st.nextToken();
				marcaViatura=st.nextToken();
				modeloViatura=st.nextToken();
				codeViatura=Integer.parseInt(st.nextToken());
				cilindragem=Integer.parseInt(st.nextToken());
				precoViatura=Integer.parseInt(st.nextToken());
				
				c=(st.nextToken()).charAt(0);
				switch(c)
				{
					case 'p': case 'P':
						tipoViatura=st.nextToken();
						c=(st.nextToken()).charAt(0);
						switch(c)
						{
							case 'd': case 'D':
								dataCDoutoramento=st.nextToken();
								doutorado(numeroTelefone,nomeCliente,dataCompra,estadoCompra,marcaViatura,modeloViatura,codeViatura,cilindragem,precoViatura,tipoViatura,dataCDoutoramento);
								break;
							case 'n': case 'N':
								estrangeiro=st.nextToken();
								numeroAnosForaPais=Integer.parseInt(st.nextToken());
								normal(numeroTelefone,nomeCliente,dataCompra,estadoCompra,marcaViatura,modeloViatura,codeViatura,cilindragem,precoViatura,tipoViatura,estrangeiro,numeroAnosForaPais);
								break;
						}
						break;
					case 'e': case 'E':
						qtyViaturas=Integer.parseInt(st.nextToken());
						c=(st.nextToken()).charAt(0);
						switch(c)
						{
							case 'r': case 'R':
								nomeComercial=st.nextToken();
								revendedor(numeroTelefone,nomeCliente,dataCompra,estadoCompra,marcaViatura,modeloViatura,codeViatura,cilindragem,precoViatura,qtyViaturas,nomeComercial);
								break;
							case 'e': case 'E':
								nomeIGovernal=st.nextToken();
								incluirManutencao=st.nextToken();
								estado(numeroTelefone,nomeCliente,dataCompra,estadoCompra,marcaViatura,modeloViatura,codeViatura,cilindragem,precoViatura,qtyViaturas,nomeIGovernal,incluirManutencao);
								break;
						}
						break;
				}
				linha=br.readLine();
			}
			a.trimToSize();
			br.close();
		}
		catch(FileNotFoundException fn)
		{
			System.out.println("|====================================|");
			System.out.println("| Nao contra o ficheiro de Dados.txt |");
			System.out.println("|====================================|");
		}
		catch(NumberFormatException nf)
		{
			System.out.println(nf.getMessage());
		}
		catch(IOException io)
		{
			System.out.println(io.getMessage());
		}
		System.out.println("|=========================================|");
		System.out.println("| Ficheiro de Dados.txt lido com Sucesso! |");
		System.out.println("|=========================================|\n");
	}
	public void remover_cliente_entregue()
	{
		fi.remover(a);
	}
	public void visualizar_Compra_MulherMoz()
	{
		vis.visualizar_MulherMocambicana(a);		
	}
	public void situcao_Empreza()
	{
		float valorTotal,margem;
		
		valorTotal=cal.acumuladorGeral(a);
		margem=cal.calculo_margem(valorTotal);
		vis.visualizar_Situacao(valorTotal,margem);
	}
	public void pesquisa_nome_codigo()
	{
		int posicao,code;
		String nome;
		
		code=val.validarCode();
		nome=val.validarNome();
		posicao=pes.pesquisa(a,code,nome);
		vis.visualizar_Pesquisa(posicao,a);
	}
	public void acumulador_direitos_adoaneiro()
	{
		float valorAdoaneiro;
		
		valorAdoaneiro=cal.acumuladorAdoaneiro(a);
		vis.visualizar_AcumuladorAdoaneiro(valorAdoaneiro);
	}
	public void acumulador_com_todosIT()
	{
		float valorTotal;
		
		valorTotal=cal.acumuladorGeral(a);
		vis.visualizar_AcumuladorGeral(valorTotal);
	}
	public void ler_Objecto()
	{
		a=fi.lerOBJ();
	}
	public void escrever_Objecto()
	{
		fi.escreverOBJ(a);
	}
	public void visualizar_Doutorado()
	{
		vis.visualizar_Doutorado(a);
	}
	public void visualizar_Estado()
	{
		vis.visualizar_Estado(a);
	}
	public void visualizar_Revendedor()
	{
		vis.visualizar_Revendedor(a);
	}
	public void visualizar_Normal()
	{
		vis.visualizar_Normal(a);
	}
	public void visualizar_todos()
	{
		vis.visualizarTClientes(a);
	}
	public void CT_de_cada_cliente()
	{
		vis.visualizar_CT();
	}
	public void revendedor(String numeroTelefone,String nomeCliente,String dataCompra,String estadoCompra,String marcaViatura,String modeloViatura,int codeViatura,int cilindragem,int precoViatura,int qtyViaturas,String nomeComercial)
	{
		Revendedor r=new Revendedor();
		
		r.setnumeroTelefone(numeroTelefone);
		r.setnomeCliente(nomeCliente);
		r.setdataCompra(dataCompra);
		r.setestadoCompra(estadoCompra);
		r.setmarcaViatura(marcaViatura);
		r.setmodeloViatura(modeloViatura);
		r.setcodeViatura(codeViatura);
		r.setcilindragem(cilindragem);
		r.setprecoViatura(precoViatura);
		r.setqtyViaturas(qtyViaturas);
		r.setnomeComercial(nomeComercial);
		
		a.add(r);
	}
	public void estado(String numeroTelefone,String nomeCliente,String dataCompra,String estadoCompra,String marcaViatura,String modeloViatura,int codeViatura,int cilindragem,int precoViatura,int qtyViaturas,String nomeIGovernal,String incluirManutencao)
	{
		Estado e=new Estado();
		
		e.setnumeroTelefone(numeroTelefone);
		e.setnomeCliente(nomeCliente);
		e.setdataCompra(dataCompra);
		e.setestadoCompra(estadoCompra);
		e.setmarcaViatura(marcaViatura);
		e.setmodeloViatura(modeloViatura);
		e.setcodeViatura(codeViatura);
		e.setcilindragem(cilindragem);
		e.setprecoViatura(precoViatura);
		e.setqtyViaturas(qtyViaturas);
		e.setnomeIGovernal(nomeIGovernal);
		e.setincluirManutencao(incluirManutencao);
		
		a.add(e);
	}
	public void normal(String numeroTelefone,String nomeCliente,String dataCompra,String estadoCompra,String marcaViatura,String modeloViatura,int codeViatura,int cilindragem,int precoViatura,String tipoViatura,String estrangeiro,int numeroAnosForaPais)
	{
		Normal n=new Normal();
		
		n.setnumeroTelefone(numeroTelefone);
		n.setnomeCliente(nomeCliente);
		n.setdataCompra(dataCompra);
		n.setestadoCompra(estadoCompra);
		n.setmarcaViatura(marcaViatura);
		n.setmodeloViatura(modeloViatura);
		n.setcodeViatura(codeViatura);
		n.setcilindragem(cilindragem);
		n.setprecoViatura(precoViatura);
		n.settipoViatura(tipoViatura);
		n.setestrangeiro(estrangeiro);
		n.setnumeroAnosForaPais(numeroAnosForaPais);
		
		a.add(n);
	}
	public void doutorado(String numeroTelefone,String nomeCliente,String dataCompra,String estadoCompra,String marcaViatura,String modeloViatura,int codeViatura,int cilindragem,int precoViatura,String tipoViatura,String dataCDoutoramento)
	{
		Doutorado d=new Doutorado();
		
		d.setnumeroTelefone(numeroTelefone);
		d.setnomeCliente(nomeCliente);
		d.setdataCompra(dataCompra);
		d.setestadoCompra(estadoCompra);
		d.setmarcaViatura(marcaViatura);
		d.setmodeloViatura(modeloViatura);
		d.setcodeViatura(codeViatura);
		d.setcilindragem(cilindragem);
		d.setprecoViatura(precoViatura);
		d.settipoViatura(tipoViatura);
		d.setdataCDoutoramento(dataCDoutoramento);
		
		a.add(d);
	}
}
