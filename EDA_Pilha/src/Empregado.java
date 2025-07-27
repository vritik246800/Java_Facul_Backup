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
	    return codigo;
	}
	public String getNome()
	{
	    return nome;
	}
	public String getTitulo()
	{
	    return titulo;
	}
	public double getSalario()
	{
	    return salario;
	}
	public void setCodigo(int codigo)
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
	    return " Codigo: "+codigo+"\n Nome: "+nome+"\n Titulo: "+titulo+"\n Salario: "+salario+"\n";
	}
}