/*
	OBJ Seguro
		numeroApolice
		tipoSeguro
			trabalho
			acidente
			vida
		valorSeguro
		valor final com IVA +16%
	read File
	ArrayList
	JMenuBarr
		JMenu
			Ficherio
				JMenu
					Ler do Fichero
					Sair Programa
			Oprecoes
				JMenu
					Novo Seguro
						new Window
							escrever tudos 
							criar OBJ
							guardarArrayList
							filewrite (true)
							JOptionPane(Tabela)
					writeFileObj
			Visualizacoes
				JMenu
					Todos Seguros
						VIZ JTabel
							new Window
						
					Tarefas
						JMenuItem
							Remover um apolice do KEyB
							Calculo ACUM VF
								JOptionPane acum
 */
public class Seguro 
{
	private int numeroA;
	private String tipoSeg;
	private float vp;
	
	public Seguro(String tipoSeg,int numeroA,float vp)
	{
		this.tipoSeg=tipoSeg;
		this.numeroA=numeroA;
		this.vp=vp;
		
	}
	public Seguro()
	{
		this("",0,0);
	}
	public int getnumeroA()
	{
		return numeroA;
	}
	public String gettipoSeg()
	{
		return tipoSeg;
	}
	public float getvp()
	{
		return vp;
	}
	public void settipoSeg(String tipoSeg)
	{
		this.tipoSeg=tipoSeg;
	}
	public void setvp(float vp)
	{
		this.vp=vp;
	}
	public void setnumeroA(int numeroA)
	{
		this.numeroA=numeroA;
	}
	public float iva()
	{
		final float IVA=16/100f;
		return vp*IVA;
	}
	public float vf()
	{
		return vp+iva();
	}
}














