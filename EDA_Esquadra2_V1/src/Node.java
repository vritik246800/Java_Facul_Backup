//package dataStructures;
import java.io.Serializable;

public class Node <E> implements Serializable
{
	// Element stored in the node.
	private E element;
	// (Pointer to) the left child.
	private Node<E> leftChild;
	// (Pointer to) the right child.
	private Node<E> rightChild;
	public Node( E theElement )
	{
		this(theElement, null, null);
	}
	public Node( E theElement, Node<E> theLeft,Node<E> theRight )
	{
		element = theElement;
		leftChild = theLeft;
		rightChild = theRight;
	}
	public E getElement( )
	{
		return element;
	}
	public Node<E> getLeft( )
	{
		return leftChild;
	}
	public Node<E> getRight( )
	{
		return rightChild;
	}
	public void setElement( E newElement )
	{
		element = newElement;
	}
	public void setLeft( Node<E> newLeft )
	{
		leftChild = newLeft;
	}
	public void setRight( Node<E> newRight )
	{
		rightChild = newRight;
	}
	// Returns true if the node is a leaf.
	public boolean isLeaf( )
	{
		return leftChild == null && rightChild == null;
	}
}
