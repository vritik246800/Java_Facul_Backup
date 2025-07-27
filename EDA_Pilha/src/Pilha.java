import java.util.*;

public interface Pilha <E>
{
    public boolean isEmpty( );

    public int size( );

    public void push(E element) throws FullStackException;
    
    public E top( ) throws EmptyStackException;

    public E pop( ) throws EmptyStackException;
} 
