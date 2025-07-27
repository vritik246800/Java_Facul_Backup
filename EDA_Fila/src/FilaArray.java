
public class FilaArray <E> implements Fila <E>
{
	
	public static final int CAPACITY = 1000;
	protected E[] array;
	protected int front;
	protected int rear;
	protected int currentSize;
	
	public FilaArray( )
	{
		this(CAPACITY);
	}
	public FilaArray(int capacity )
	{
		array = (E[]) new Object[capacity];
		front = 0;
		rear = capacity-1;
		currentSize = 0;
	}
	public boolean isEmpty()
	{
		return currentSize==0;
	}
	public boolean isFull()
	{
		return currentSize==array.length;
	}
	public int size()
	{
		return currentSize;
	}
	protected int nextIndex(int index)
	{
		return (index+1)%array.length;
	}
	public void enqueue(E element) throws FullQueueException
	{
		if(this.isFull())
			throw new FullQueueException("Queue is full");
		
		rear=this.nextIndex(rear);
		array[rear]=element;
		currentSize++;
	}
	public E dequeue() throws EmptyQueueException
	{
		if(this.isEmpty())
			throw new EmptyQueueException("Queue is emplty");
		
		E element=array[front];
		array[front]=null;
		front=this.nextIndex(front);
		currentSize--;
		return element;
	}
	
	
}







