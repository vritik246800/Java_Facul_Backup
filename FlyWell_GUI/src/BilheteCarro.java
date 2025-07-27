
public final class BilheteCarro extends Bilhete 
{
	private String matricula,marca;
	private int anoFabrico;
	public static int ctC=0;
	
	public BilheteCarro(String destino,String passaport,int valor,String matricula,String marca,int anoFabrico)
	{
		super(destino,passaport,valor);
		this.matricula=matricula;
		this.marca=marca;
		this.anoFabrico=anoFabrico;
		ctC++;
		
	}
	public BilheteCarro()
	{
		this("","",0,"","",0);
	}
	public String getmatricula() {return matricula;}
	public String getmarca() {return marca;}
	public int getanoFabrico() {return anoFabrico;}
	
	public void setanoFabrico(int anoFabrico) {this.anoFabrico=anoFabrico;}
	public void setmarca(String marca) {this.marca=marca;}
	public void setmatricula(String matricula) {this.matricula=matricula;}

}
