import java.io.*;

public class Bilhete implements Serializable
{
	protected int code;
	protected float valor;
	protected String dataC,dataP,bi,nome,formaP;
	Bilhete(int code,float valor,String bi,String dataP,String dataC,String nome,String formaP)
	{
		this.code=code;
		this.valor=valor;
		this.bi=bi;
		this.dataP=dataP;
		this.dataC=dataC;
		this.nome=nome;
		this.formaP=formaP;
	}
	Bilhete()
	{
		this(0,0,"","","","","");
	}
	
	void setcode(int code)
	{
		this.code=code;
	}
	int getcode()
	{
		return code;
	}
	void setvalor(float valor)
	{
		this.valor=valor;
	}
	void setbi(String bi)
	{
		this.bi=bi;
	}
	void setdataP(String dataP)
	{
		this.dataP=dataP;
	}
	void setdataC(String dataC)
	{
		this.dataC=dataC;
	}
	void setnome(String nome)
	{
		this.nome=nome;
	}
	void setformaP(String formaP)
	{
		this.formaP=formaP;
	}
	public String toString()
	{
		return "Code: "+code+"\tValor: "+valor+"\tBI: "+bi+"\tDataP: "+dataP+"\tDataC: "+dataC+"\tNome: "+nome+"\tForma de Pagamento: "+formaP;
	}
}
