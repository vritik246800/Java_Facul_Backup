

public class Funcionario 
{
	private String nome,cargo;
	private int salsarioB;
	
	public Funcionario(String nome,String cargo,int salarioB)
	{
		this.nome=nome;
		this.cargo=cargo;
		this.salsarioB=salarioB;
	}
	public Funcionario()
	{
		this("","",0);
	}
	public String getnome() {return nome;}
	public void setnome(String nome) {this.nome=nome;}
	public String getcargo() {return cargo=cargo;}
	public void setcargo(String cargo) {this.cargo=cargo;}
	public int getsalsarioB() {return salsarioB;}
	public void setsalsarioB(int salsarioB) {this.salsarioB=salsarioB;}
	
	
	
}
