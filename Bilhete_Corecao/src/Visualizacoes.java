import java.text.DecimalFormat;
import java.util.*;
public class Visualizacoes 
{
	private DecimalFormat df;
	public Visualizacoes() 
	{
		df = new DecimalFormat("###,###,###.00MTs");
	}
	
	public String visualizarTodosBilhetes(ArrayList v) 
	{
		String s ="";
		for (int i = 0; i < v.size(); i++) 	
			s += v.get(i)+"\n";
		return s;
	}
	
	public void visualizarBilhetePesquisado(ArrayList v, int p) 
	{
		if(p>=0)
			System.out.println("Bilhete encontrado: "+v.get(p));
		else
			System.out.println("Bilhete nao foi encontrado!");
	}

	public void visualizarQuantidades() 
	{
		System.out.println("Quantidade de bilhetes por tipo:");
		System.out.println("Carros:"+Carro.contV+", Comboio: "+Comboio.contC+", Aereo: "+Aereo.contA+", Mar: "+Mar.contM);
	}

	public void visualizarValorTotal(float valT) 
	{
		System.out.println("Valor Total: "+df.format(valT));		
	}

	public void visualizarVooMaisLongo(ArrayList bilhetes, int indMaior) 
	{
		System.out.println("Voo Mais longo: "+bilhetes.get(indMaior));
	}
	
	
}
