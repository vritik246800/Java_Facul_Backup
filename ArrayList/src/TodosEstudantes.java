import java.util.*;

public class TodosEstudantes
{ 
	//1. Definição da estrutura
	private ArrayList array; 
	
	//ArrayList (não precisa o cont)
	private Ordenacoes ord; 
	private Visualizacoes vis;
	
	public TodosEstudantes() 
	{ 
		//2. init
		array = new ArrayList(); 
		
		vis = new Visualizacoes();
		ord = new Ordenacoes();
	}
	public void inserirEstudante()
	{
		//3. Preenchimento do obj
		Estudante est = new Estudante();
		
		//add no ArrayList
		array.add(est); 
		
		//ajuste do tamanho
		array.trimToSize(); 
	}
	public String toString() 
	{ 
		return vis.toString(array); 
	}
	public void Ordenar()
	{
		ord.ordenarPorMedia(array);
	}
}
