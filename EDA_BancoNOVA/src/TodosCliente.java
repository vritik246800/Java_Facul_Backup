import java.io.*;
import java.util.*;

public class TodosCliente 
{
	private Cliente [] array;
	private int ct;
	
	private Viz vis;
	private Pesquisa pes;
	private Validar val;
	private File esc;
	private String trans;
	
	public TodosCliente()
	{
		ct=0;
		array = new Cliente[100];
		
		vis=new Viz();
		pes=new Pesquisa();
		val=new Validar();
		esc=new File();
		trans="";
		
	}
	public void todos()
	{
		String linha,nome,sex;
		float valorD;
		int idade,numeroC,pin;
		
		StringTokenizer seccao;
		
		try
		{
			FileReader fr=new FileReader("Dados.txt");
			BufferedReader br=new BufferedReader(fr);
			
			linha=br.readLine();
			
			while(linha!=null)
			{
				seccao=new StringTokenizer(linha,";");
				
				nome=seccao.nextToken();
				sex=seccao.nextToken();
				idade=Integer.parseInt(seccao.nextToken());
				numeroC= Integer.parseInt(seccao.nextToken());
				pin=Integer.parseInt(seccao.nextToken());
				valorD=Float.parseFloat(seccao.nextToken());
				
				
				array[ct]=new Cliente(nome,sex,idade,numeroC,pin,valorD);
				ct++;
				
				linha=br.readLine();
			}
			br.close();
		}
		catch(FileNotFoundException z)
		{
			System.out.println("File de txt nao encontra !!");
		}
		catch(NumberFormatException x)
		{
			System.out.println(x.getMessage());
		}
		catch(IOException c)
		{
			System.out.println(c.getMessage());
		}
		System.out.println("|=========================|");
		System.out.println("|File lido com Successo ! |");
		System.out.println("|=========================|\n");
	}
	public void registo()
	{
		Random r = new Random();
		String nome,sex;
		int idade, numeroC,pin;
		float valorD;
		
		nome=val.nome("|Introduz o nome(>2)|","|===================|");
		sex=val.sex("|Introduz o sexo (Masculino || Feminino )|","|========================================|");
		idade=val.idade("|Introduz a idade(>=18)|","|======================|");
		numeroC = r.nextInt(9999999, 99999999);
		pin=r.nextInt(1000,9999);
		valorD=val.valorD("|Introduz o valor que quera depositar(>0.0)|","|==========================================|");
		
		esc.novoR(nome,sex,idade,numeroC,pin,valorD);
		trans(nome,sex,"Novo registo",valorD);
		
	}
	public void records()
	{
		esc.escreverR(trans);
	}
	public void trans(String nome,String sex,String opcao,float valorD)
	{
		trans+="Nome: "+nome+";"+"Sexo: "+sex+";"+"Opecao: "+opcao+";"+"Valor: "+valorD;
	}
	public void trocaPIN()
	{
		int poz, numeroC=0,pin;
		
		numeroC=val.validarNC("|Introduza o numero da conta que pretende consultar (XXXXXXXX)|","|=============================================================|");
		poz=pes.pesquisa(ct,array,numeroC);
		pin=val.pin("|Introduz o seu PIN (XXXX) |","|==========================|");
		if(pin==array[poz].getpin())
		{
			pin=val.pin("|Introduz o novo PIN (XXXX) |","|===========================|");
			array[poz].actualizarPin(pin);
			esc.actualizarPIN(array,ct,poz,pin);
		}
		else
		{
			System.out.println("|=================|");
			System.out.println("| PIN Incorrecto !|");
			System.out.println("|=================|\n");
		}
		
		trans(array[poz].getnome(),array[poz].getsex(),"Troca do PIN ",-2);
	}
	public void cosulta()
	{
		int poz, numeroC=0,pin;

		numeroC=val.validarNC("|Introduza o numero da conta que pretende consultar (XXXXXXXX)|","|=============================================================|");
		poz=pes.pesquisa(ct,array,numeroC);
		pin=val.pin("|Introduz o seu PIN (XXXX) |","|==========================|");
		if(pin==array[poz].getpin())
		{
			vis.vizPEQ(array,poz);
			array[poz].actualizarPin(pin);
		}
		else
		{
			System.out.println("|=================|");
			System.out.println("| PIN Incorrecto !|");
			System.out.println("|=================|\n");
		}
		trans(array[poz].getnome(),array[poz].getsex(),"Consulta de saldo",-1);
	}
	public String toString()
	{
		return vis.toString(ct,array);
	}
	public void depositos()
	{
		
		int numeroC, poz=0;
		float valorD, valorN;

		valorN = val.valorD("|Introduza o valor a depositar (>0): |","|====================================|");
		numeroC = val.validarNC("|Introduza o numero da conta onde pretende depositar (XXXXXXXX) |","|===============================================================|");
		poz=pes.pesquisa(ct,array,numeroC);
		
		valorD = array[poz].getvalorD();

		System.out.println("|===============\\\\");
		System.out.println("|Saldo anterior: " +valorD);
		System.out.println("|===============//");

		valorD += valorN ;
		
		System.out.println("|===============\\\\");
		System.out.println("|Saldo actual:   " +valorD);
		System.out.println("|===============//");
		
		esc.actualizarFile(array, ct, valorD,poz);
		
		trans(array[poz].getnome(),array[poz].getsex(),"Deposito",valorN);
		array[poz].actualizarvalorD(valorD);
	}
	public void levantamento()
	{
		int numeroC, poz=0,pin=0;
		float valorD, valorN;
		
		valorN = val.valorD("|Introduza o valor a levantamento (>0): |","|=======================================|");
		numeroC = val.validarNC("|Introduza o numero da conta onde pretende depositar (XXXXXXXX) |","|===============================================================|");
		
		poz=pes.pesquisa(ct,array,numeroC);
		
		if(poz==-1)
		{
			System.out.println("|==============================|");
			System.out.println("|O Numero de conta nao existe !|");
			System.out.println("|==============================|\n");
		}
		else
		{
			pin=val.pin("|Introduz o seu PIN (XXXX) |","|==========================|");
			if(pin==array[poz].getpin())
			{
				if(array[poz].getvalorD()<=0 || array[poz].getvalorD()<valorN)
				{
					System.out.println("|====================|");
					System.out.println("|Saldo insuficiente !|");
					System.out.println("|====================|\n");
				}
				else
				{
					valorD = array[poz].getvalorD();
			
					System.out.println("|===============\\\\");
					System.out.println("|Saldo anterior: " +valorD);
					System.out.println("|===============//");
			
					valorD -= valorN ;
					
					System.out.println("|===============\\\\");
					System.out.println("|Saldo actual:   " +valorD);
					System.out.println("|===============//");
					
					esc.actualizarFile(array, ct, valorD,poz);
					
					trans(array[poz].getnome(),array[poz].getsex(),"Levantamento",valorN);
					array[poz].actualizarvalorD(valorD);
				}
			}
			else
			{
				System.out.println("|=================|");
				System.out.println("| PIN Incorrecto !|");
				System.out.println("|=================|");
			}
			
		}
	}
	public void transferencia()
	{
		
		int numeroC,numeroC1, poz=0,poz1=0,pin=0;
		float valorD, valorN;
		
		valorN = val.valorD("|Introduza o valor a transferir (>0): |","|=====================================|");
		numeroC = val.validarNC("|Introduza o numero da conta da sua conta (XXXXXXXX) |","|====================================================|");
		poz=pes.pesquisa(ct,array,numeroC);
		
		if(poz==-1)
		{
			System.out.println("|==============================|");
			System.out.println("|O Numero de conta nao existe !|");
			System.out.println("|==============================|\n");
		}
		else
		{
			numeroC1 = val.validarNC("|Introduza o numero da conta onde pretende transferir (XXXXXXXX) |","|================================================================|");
			poz1=pes.pesquisa(ct,array,numeroC1);
			
			if(poz1==-1)
			{
				System.out.println("|==============================|");
				System.out.println("|O Numero de conta nao existe !|");
				System.out.println("|==============================|\n");
			}
			else
			{
				pin=val.pin("|Introduz o seu PIN (XXXX) |","|==========================|");
				if(pin==array[poz].getpin())
				{
					if(array[poz].getvalorD()<=0 || array[poz].getvalorD()<valorN)
					{
						System.out.println("|====================|");
						System.out.println("|Saldo insuficiente !|");
						System.out.println("|====================|\n");
					}
					else
					{
						valorD = array[poz].getvalorD();
				
						System.out.println("|===============\\\\");
						System.out.println("|Saldo anterior: " +valorD);
						System.out.println("|===============//");
				
						valorD -= valorN ;
						
						System.out.println("|===============\\\\");
						System.out.println("|Saldo actual:   " +valorD);
						System.out.println("|===============//\n");
						System.out.println("|======================================================================|");
						System.out.println("|Tranferencia feito com successo , obrigado por confiar no nosso Banco |");
						System.out.println("|======================================================================|\n");
						
						esc.actualizarFileT(array,ct,poz,poz1,valorN);
						
						trans(array[poz].getnome(),array[poz].getsex(),"Transferencia",valorN);
						array[poz].actualizarvalorD(valorD);
					}
				}
				else
				{
					System.out.println("|=================|");
					System.out.println("| PIN Incorrecto !|");
					System.out.println("|=================|");
				}
			}
		}
	}
	public void elOBJ()
	{
		Escrever_LerOBJ o=new Escrever_LerOBJ();
		
		o.escreverO(array);
		o.lerO(array);
	}
}






