import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;


class Biblioteca 
{
	 String host = "10.108.252.179";
     String port = "1521";
     String sid  = "XE";
     String url = "jdbc:oracle:thin:@" + host + ":" + port + ":" + sid;

     String user = "E2019";       
     String password = "2002";

     public static Connection conn = null;
     public static Statement st = null;
     public static ResultSet rs = null;
     
     private Visualizar viz;
	
	Biblioteca()
	{
		viz=new Visualizar();
		
		
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		try
	    {
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		conn = DriverManager.getConnection(url, user, password);
    		System.out.println("✅ Conectado com sucesso ao Oracle!");
    		
    		 viz.vizualizar_Tabela_Regiao(rs,st,conn);
    		
	    }
    	catch(SQLException e)
    	{
    		System.out.println("Erro ao conectar com o banco de dados: " + e.getMessage());
    	}
    	catch(ClassNotFoundException cn)
    	{
    		System.out.println(cn.getMessage());
    	}
	 	finally
	 	{
           try 
           {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (conn != null) conn.close();
           } 
           catch (SQLException e) 
           {
                System.out.println(e.getMessage());
           }
	 	}
		 
		
	}
	
	public static void main(String[]args){new Biblioteca();}

}
