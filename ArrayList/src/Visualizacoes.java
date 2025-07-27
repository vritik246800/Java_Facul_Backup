import java.util.ArrayList;
public class Visualizacoes 
{
	public String toString(ArrayList array)
	{
		String n = "";
		Estudante aux;
		for(int i = 0; i < array.size(); i++)
		{
			aux = (Estudante) array.get(i);
			n += aux + "\n";
		}
		return n;
	}
	public String toString2(ArrayList<Estudante> array)
	{
		String n = "";
		Estudante aux;
		for(int i = 0; i < array.size(); i++)
		{
			aux = array.get(i);
			n += aux + "\n";
		}
		return n;
	}
} //FIM DA CLASSE VISUALIZACOES