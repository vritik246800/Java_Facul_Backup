import java.util.*;

public class Remocoes 
{
	public Remocoes() {	}

	public void removerPorCodigo(ArrayList v, int i) 
	{	
		if(i>=0)
		{
			v.remove(i);
			v.trimToSize();
			System.out.println("Bilhete removido!");
			//NOTA: Deve decrementar as variaveis estaticas para reflectir na contagem
		}	
		else
			System.out.println("Bilhete nao foi encontrado!");	
	}
}
