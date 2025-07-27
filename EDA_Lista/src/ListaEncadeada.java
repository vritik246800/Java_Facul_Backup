import java.util.*;

public class ListaEncadeada <E> implements Lista <E>
{
    private Node head;
    private int contador;
    
     //Construtor
     public ListaEncadeada()
     {
        this.head=new Node(null);
        contador=0;
    }
    public void createEmptyList()
    {
    	head = new Node(null);
    	contador = 0;
    }
    public int size()
    {
        return contador;
    }
    public void add(E data)
    {
	    Node temp = new Node(data);
	    Node current = head;
	        while(current.getNext() != null)
	        {
	        	current = current.getNext();
	        }
	    current.setNext(temp);
	    contador++; // incrementa a variável de número de elementos
    }
    public void add(int index, E data)
    {
    	Node temp = new Node(data);
    	Node current = head;
        for(int i = 1; i < index && current.getNext() != null; i++)
        {
        	current = current.getNext();
        }
        temp.setNext(current.getNext());
	    current.setNext(temp);
	    contador++;
    }
    public E get(int index)throws InvalidPositionException
    {
        if(index <= 0) throw new InvalidPositionException ("Indice Inválido");

            Node current = head.getNext();
            for(int i = 1; i < index; i++)
            {
            	if(current.getNext() == null) throw new InvalidPositionException("Indice Inválido");
            	current = current.getNext();
            }
            return (E) current.getData();
    }
    public boolean remove(int index) throws InvalidPositionException
    {
	    if(index < 1 || index > size())
	    throw new InvalidPositionException("Índice Inválido");
	        Node current = head;
	        for(int i = 1; i < index; i++)
	        {
		        if(current.getNext() == null)
		        return false;
		        current = current.getNext();
	        }
	    current.setNext(current.getNext().getNext());
	    contador--;
	    return true;
    }
}

