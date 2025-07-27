import java.sql.*;

public class ConexaoBD 
{
	public static final String HOSTNAME="localhost";
	public static final String PORTA="5432";
	public static final String DBNAME="postgres";
	public static final String USERNAME="200202";
	public static final String PASSWORD="200202";
	
	public static Connection getConnectionToDB()
	{
		Connection con=null;
		try
		{
			con=DriverManager.getConnection("jdbc:postgresql://"+HOSTNAME+":"+PORTA+"/"+DBNAME,USERNAME,PASSWORD);
		}
		catch(SQLException e)
		{
			System.out.println(e.getErrorCode());
			System.out.println(e.getSQLState());
			System.out.println(e.getMessage());
		}
		return con;
	}
}
