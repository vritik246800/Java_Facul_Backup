public class Node<E> 
{
	private Node next; 
	private E data; 
	public Node(E data)
	{
        next=null;
        this.data=data;
    }
	public Node(Node next, E data)
	{
        this.next=next;
        this.data=data;
    }
    public Node getNext() 
    {
        return next;
    }
    public E getData() 
    {
        return data;
    }
    public void setNext(Node next) 
    {
        this.next = next;
    }
    public void setData(E data) 
    {
        this.data = data;
    }
}
