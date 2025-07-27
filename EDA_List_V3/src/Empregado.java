 
public class Empregado
{
	private int codigo;
	private String nome;
	private String titulo;
	private double salario;
	
	public Empregado(int codigo, String nome, String titulo, double salario)
	{
		this.codigo=codigo;
		this.nome=nome;
		this.titulo=titulo;
		this.salario=salario;   
	}

	public int getCodigo()
	{
		return this.codigo;
	}
	public String getNome()
	{
		return this.getNome();
	}
	public String getTitulo()
	{
		return this.getTitulo();
	}
	public double getSalario()	
	{
		return this.getSalario();
	}

	public void setCodigo(int codogo)
	{
		this.codigo=codigo;
	}
	public void setNome(String nome)
	{
		this.nome=nome;
	}
	public void setTitulo(String titulo)
	{
		this.titulo=titulo;
    }
	public String toString()
	{
		return " Codigo: "+this.codigo+"\n Nome: "+this.nome+"\n Titulo: "+this.titulo+"\n Salario: "+this.salario+"\n";
	}
}
