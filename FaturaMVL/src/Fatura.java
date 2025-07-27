public class Fatura 
{
    private String nome,data;
    private int numeroC;
    public Fatura(String nome,int numeroC,String data)
    {
        this.nome=nome;
        this.numeroC=numeroC;
        this.data=data;   
    }
    public String getnome()
    {
        return nome;
    }
    public String getdata()
    {
        return data;
    }
    public int getNumer()
    {
        return numeroC;
    }
    public String toString()
    {
        return "[Nome: "+nome+"\t|Numero da Caixa: "+numeroC+"\t|Data: "+data+"\t]";
    }
}