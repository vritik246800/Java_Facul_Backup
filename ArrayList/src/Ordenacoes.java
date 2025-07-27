import java.util.*;
public class Ordenacoes 
{
	public Ordenacoes() 
	{
		
	}
	public void ordenarPorMedia(ArrayList array)
	{
		int ind_maior;
		for (int i = 0; i < array.size()-1; i++)
		{
			ind_maior = localizarMaior(array, i);
			troca(array, i, ind_maior);
		}
		System.out.println("Ordenados com sucesso!");
	}
	
	private int localizarMaior(ArrayList array, int inicio)
	{
		int ind_maior = inicio;
		Estudante aux1, aux2;
		
		for( int i = inicio + 1; i < array.size(); i++)
		//4. Para buscar os respectivos obj
		{
			aux1 = (Estudante) array.get(i);
			aux2 = (Estudante) array.get(ind_maior);
			
			if(aux1.getMedia() > aux2.getMedia())
				ind_maior = i;
		}
		return ind_maior;
	}
	
	// usamos os privates de que public pra o metodo ser exclusivo para aquela class
	
	private void troca(ArrayList array, int i, int ind_maior)
	{
		Estudante aux1, aux2;
		aux1 = (Estudante) array.get(i);
		aux2 = (Estudante) array.get(ind_maior);
		array.set(i, aux2); array.set(ind_maior, aux1); //ArrayList
	}
} //FIM DA CLASSE ORDENACOES


