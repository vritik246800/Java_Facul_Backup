
public class Executavel 
{
	public static void main(String[]args)
	{
		TodosProGym t=new TodosProGym();
		
		t.todo();
		System.out.println("Antes Orden");
		t.todalista();
		t.listFamilia();
		t.listEstudante();
		t.ct();
		t.remove();
		t.calculo();
		t.escreverO();
		t.ordenar();
		System.out.println("Depois Orden");
		t.todalista();
		
	}
}
