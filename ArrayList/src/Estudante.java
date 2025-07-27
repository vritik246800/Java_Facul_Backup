import java.io.*;

public class Estudante 
{
	private Validacoes val;
	private String nome;
	private float notas[];
	private byte media;
	
	public Estudante() 
	{
		int quant;
		val = new Validacoes();
		nome = val.validarString("Introduza o nome: ");
		quant= val.validarByte(1,6, "Introduza aquantidade de notas (1-6):");
		notas = inserirNotas((byte)quant);
		media = calcularMedia(); 
	}
	//Cria array Notas e preenche com notas do estudante
	private float[] inserirNotas(byte q)
	{ 
		float [] a = new float[q];
		for(int i = 0; i < q; i++)
			a[i] = val.validarFloat(0, 20, "Insira a "+(i+1)+"a nota(0-20):");
		return a; 
	}
	//devolve uma String composta pelas notas de um estudante
	private String verNotas() 
	{
		String s = "";
		for (int i = 0; i < notas.length; i++)
			s += notas[i]+" ";
		return s;
	}
	//Método para cálculo da média de um estudante
	private byte calcularMedia()
	{
		float soma = 0;
		for (int i = 0; i < notas.length; i++)
		soma += notas[i];
		return (byte) Math.round(soma/notas.length);
	}
	public byte getMedia() 
	{ 
		return media; 
	}
	public String toString()
	{
		return "Estudante [nome=" + nome + ", notas=" + verNotas()+ ", media=" + media + "]";
	}
} //FIM DA CLASSE ESTUDANTE
