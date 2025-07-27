
public abstract class Deposito extends Conta implements API
{
	protected char tipo;
	
	public Deposito(float saldo,String nConta,String dataA,char tipo)
	{
		super(saldo,nConta,dataA);
		this.tipo=tipo;
	}
	//public Deposito()
	//{
	//	this(0,"","",' ');
	//}
	// PK e class abstract por isso
	public float cP()
	{
		return saldo*TAX;
	}
	public void settipo(char tipo)
	{
		this.tipo=tipo;
	}
	public char gettipo()
	{
		return tipo;
	}
	public String toString()
	{
		return super.toString()+"\tO tipo de Conta deposito: ";
	}
	
}
