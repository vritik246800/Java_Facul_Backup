 import java .util.*; 
public interface Lista <E>
{
	public void createEmptyList();
	public void add(E data);
	public void add(int index, E data) throws InvalidPositionException;
	public E get(int index) throws InvalidPositionException;
	public boolean remove(int index) throws InvalidPositionException;
	public int size();
}  
