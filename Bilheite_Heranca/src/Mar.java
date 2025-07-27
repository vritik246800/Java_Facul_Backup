
public class Mar extends Bilhete 
{
	private String tipoM;
	static int ctM=0;
	Mar(int code,float valor,String bi,String dataP,String dataC,String nome,String formaP,String tipo)
	{
		super(code,valor,bi,dataP,dataC,nome,formaP);
		this.tipoM=tipo;
		ctM++;
	}
	Mar()
	{
		this(0,0,"","","","","","");
	}
	void settipo(String tipo)
	{
		this.tipoM=tipo;
	}
	String gettipo()
	{
		return tipoM;
	}
	public String toString()
	{
		return "Mar :\t"+super.toString()+"\tTipo de Barco: "+tipoM;
	}
}
