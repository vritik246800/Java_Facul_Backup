
public class Executavel 
{
	public static void main(String [] args)
	{
		TodasObra t=new TodasObra();
		
		t.todo();
		System.out.println(t);
		t.vizct();
		t.ac();
		t.pesquisa();
		System.out.println(t);
		System.out.println("menos tempo: ");
		t.menosT();
	}
}
