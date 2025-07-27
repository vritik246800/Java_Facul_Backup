
public class Pesquisa
{
	private Validacao vl;
	public Pesquisa()
	{
		vl=new Validacao();
	}
	public int pesquisar(int ct,Cliente [] array)
	{
		
		int aux =-1,code;
		
		code=vl.validar("Introduz o code: ");
		
		for(int i=0;i<ct;i++)
		{
			if(array[i].getCode()==(code))
				 aux=i;
		}
		return aux ;
	}
}