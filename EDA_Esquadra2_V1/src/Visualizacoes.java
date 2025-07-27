import java.util.*;
public class Visualizacoes {
	public Visualizacoes()
	{
		
	}
	// Changed parameter to be more specific, assuming it's a list of Individuo or objects with good toString()
	public void verTodosDados(ArrayList<?> lista) // Use wildcard or specific type like ArrayList<Individuo>
	{
		String dados="";
		if (lista.isEmpty()) {
			dados = "Nenhum dado para visualizar.";
		} else {
			for(int i=0; i<lista.size(); i++)
			{
				// Ensure elements are not null before calling toString()
				if (lista.get(i) != null) {
					dados+=lista.get(i).toString()+"\n"; // Relies on a good toString() method of the elements
				} else {
					dados+="[Entrada nula na lista]\n";
				}
			}
		}
		System.out.println(dados);
	}
}