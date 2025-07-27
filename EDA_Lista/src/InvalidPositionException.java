import java.util.*;

public class InvalidPositionException extends RuntimeException
{
    public InvalidPositionException( )
    {
    	super();
    }
    public InvalidPositionException( String msg )
    {
    	super(msg);
    }   
}