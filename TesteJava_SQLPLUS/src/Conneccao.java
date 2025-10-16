import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conneccao 
{   
    private static String ip="10.108.252.179";
    private static String port="1521";
    private static String sid="XE";
    private static String url = "jdbc:oracle:thin:@"+ip+":"+port+sid;
    private static String usuario = "E2019";
    private static String senha = "2002";
    
    public static Connection getConnection()
    {
    	Connection con=null;
    	try
    	{
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		con=DriverManager.getConnection(url,usuario,senha);
    	}
    	catch(SQLException e)
    	{
    		System.out.println("Erro ao conectar com o banco de dados: " + e.getMessage());
    	}
    	catch(ClassNotFoundException cn)
    	{
    		System.out.println(cn.getMessage());
    	}
    	return con;
    }
}
