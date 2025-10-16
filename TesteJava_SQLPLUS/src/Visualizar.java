import java.sql.*;


public class Visualizar 
{
	Visualizar()
	{
		
	}
	void vizualizar_Tabela_Regiao(ResultSet rs,Statement st,Connection conn) 
	{
	    String vizTrans = "SELECT * FROM departamento";
	    try 
	    {
		    st = conn.createStatement();
		    rs = st.executeQuery(vizTrans);
		    System.out.println("|------------|----------------------|------------|");
		    System.out.println("| DEP_ID:    "+"| NOME:                |"+" REG_ID:    |");
		    System.out.println("|------------|----------------------|------------|");
		    while (rs.next()) 
		    {
		        int departamento_id = rs.getInt(1);
		        String dep_nome = rs.getString(2);
		        int regiao_id = rs.getInt(3);
		        
		        //System.out.println("DEP_ID: " + departamento_id + " | NOME: " + dep_nome + " | REG_ID: " + regiao_id);
		        
		        System.out.printf("| %-10s | %-20s | %-10s |\n",departamento_id,dep_nome,regiao_id);
		        System.out.println("|------------|----------------------|------------|");
		    }
	    } catch (SQLException e) {
	        System.out.println(e.getSQLState());
	        System.out.println(e.getMessage());
	    } 
	    finally 
	    {
	        try 
	        {
	            if (rs != null) rs.close();
	            if (st != null) st.close();
	        } 
	        catch (SQLException e) 
	        {
	            System.out.println(e.getMessage());
	        }
	    }
	}

	

}
