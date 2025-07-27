
public class Barco 
{
	protected String matricula,marca;
	protected float peso;
	
	public Barco(String matricula,String marca,float peso)
	{
		this.matricula=matricula;
		this.marca=marca;
		this.peso=peso;
	}
	public Barco()
	{
		this("","",0);
	}
	public void setmatricula(String matricula)
	{
		this.matricula=matricula;
	}
	public String getmatricula()
	{
		return matricula;
	}
	public String getmarca()
	{
		return marca;
	}
	public void setmarca(String marca)
	{
		this.marca=marca;
	}
	public float getpeso()
	{
		return peso;
	}
	public void setpeso(float peso)
	{
		this.peso=peso;
	}
	public String toString()
	{
		return "Matricula: "+matricula+"\tMarca: "+marca+"\t Peso: "+peso;
	}
}
