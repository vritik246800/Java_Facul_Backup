
public abstract class Obra 
{
	protected String nomeEng;
	protected float duracao;
	
	public Obra(String nomeEng,float duracao)
	{
		this.nomeEng=nomeEng;
		this.duracao=duracao;
	}
	public Obra()
	{
		this("",0);
	}
	public abstract float vp();
	
	public void setnomeEng(String nomeEng)
	{
		this.nomeEng=nomeEng;
	}
	public String getnomeEng()
	{
		return nomeEng;
	}
	float getduracao()
	{
		return duracao;
	}
	public void setdurcao(float durcao)
	{
		this.duracao=durcao;
	}
	public String toString()
	{
		return "Obra:\nNome de Engenheiro: "+nomeEng+"\tDuracao: "+duracao; 
	}
}
