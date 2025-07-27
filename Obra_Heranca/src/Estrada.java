
public final class Estrada extends Obra
{
	private int km;
	public static int ctEstrada=0;
	
	public Estrada(String nomeEng,float duracao,int Km)
	{
		super(nomeEng,duracao);
		this.km=Km;
		ctEstrada++;
	}
	public Estrada()
	{
		this("",0,0);
	}
	public float vp()
	{
		final int V=50000;
		return km*V;
	}
	public int getKm()
	{
		return km;
	}
	public void setkm(int numeroKm)
	{
		this.km=numeroKm;
	}
	public String toString()
	{
		return super.toString()+"\nEstrada: \nNumero de km: "+km;
	}
	
}
