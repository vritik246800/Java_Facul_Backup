
import java.util.*;
public class ImplementaPilha <E> implements Pilha <E> 
{

	private int indTop; 
	private E[] lista; 
	
	public ImplementaPilha (int tamanho)
	{
		indTop=-1;
		this.lista = (E[]) new Object[tamanho];
	}
	public boolean isEmpty()
	{
		return indTop==-1;
	}
	public void push(E x) throws FullStackException
	{
		if(this.indTop<this.lista.length-1)
		{
			this.lista[++indTop]=x;
    	}
    	else
    		throw new FullStackException("ERRO: Tentando inserir em pilha Cheia !");
	}
	public E top() throws EmptyStackException
	{
		if(this.isEmpty())
		{ 
			throw new EmptyStackException("ERRO: Tentando recuperar em pilha vazia");
		}
		return this.lista[this.indTop]; 
	}
	public int size()
	{
		if(this.isEmpty())
		{
			return 0;
		}
		return this.indTop+1;
	}
	public E pop() throws EmptyStackException
	{
		if(this.isEmpty())
		{
			throw new EmptyStackException("ERRO: Tentando remoção e recuperação em pilha vazia");
    	}
		return this.lista[this.indTop--];
	}
}
