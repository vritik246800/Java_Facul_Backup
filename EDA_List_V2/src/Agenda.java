// Agenda Eletrônica com ListaEncadeada
public class Agenda 
{
    private ListaEncadeada <Contato> contatos;

    public Agenda() 
    {
        contatos = new ListaEncadeada<>();
        contatos.createEmptyList();
    }
    public void inserirContato(Contato contato) 
    {
        contatos.add(contato);
    }
    public void inserirContato(int pos, Contato contato) 
    {
        contatos.add(pos, contato);
    }
    public void removerContato(int pos) 
    {
        contatos.remove(pos);
    }
    public void verContato(int pos) 
    {
        System.out.println(contatos.get(pos));
    }
    public int totalContatos() 
    {
        return contatos.size();
    }
    public void listarContatos() 
    {
        contatos.listar();
    }
}
