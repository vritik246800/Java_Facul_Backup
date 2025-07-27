

public interface Fila <E>
{	
	boolean isEmpty( );
	
	int size( );
	
	void enqueue( E element ) throws FullQueueException;
	
	E dequeue( ) throws EmptyQueueException;
}