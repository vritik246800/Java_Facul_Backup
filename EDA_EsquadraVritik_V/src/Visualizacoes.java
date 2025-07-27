import java.util.*;
public class Visualizacoes {
	public Visualizacoes()
	{
		
	}
	/*public void verTodosDados(ArrayList lista)
	{
		String dados="";
		for(int i=0; i<lista.size(); i++)
		{
			dados+=lista.get(i)+"\n";
		}
		System.out.println(dados);
	}*/
	public void verTodosDados(ArvoreBinaria arvore)
	{
		arvore.imprimirEmOrdem();
	}
}
