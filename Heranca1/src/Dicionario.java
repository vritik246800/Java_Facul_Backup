
public class Dicionario extends Livro
{
	private int  entradas;
	
	public Dicionario(int pag,int ent)
	{
		super(pag);// sempre ter super antes de tudo
		
		entradas=ent;
	}
	public String toString()
	{
		return super.toString()+"\nNumero de entradas= "+entradas ;
	}
}
