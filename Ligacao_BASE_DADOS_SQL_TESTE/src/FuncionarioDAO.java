import java.sql.*;
public class FuncionarioDAO 
{
	private Connection conn;
	public FuncionarioDAO()
	{
		// para criar conection com data base
		conn=ConexaoBD.getConnectionToDB();
	}
	public void inserirFuncionario(int id,String nome,String ocup,int sal)
	{
		String cmd="insert int funcionario  (id, nome, cargo, salario) values (?,?,?,?)";
		try
		{
			PreparedStatement pstm=conn.prepareStatement(cmd);
			pstm.setInt(1, id);
			pstm.setString(2, nome);
			pstm.setString(3,ocup);
			pstm.setInt(4, sal);
			// para retorna 
			int linhas=pstm.executeUpdate();
			System.out.println("linha inseridas: "+linhas);
			pstm.close();
			System.out.println("Dados Inseridos na BD com Sucesso !");
		}
		catch(SQLException e)
		{
			System.out.println("SQL State "+e.getSQLState());
			System.out.println("Mensagem"+e.getMessage());
		}
	}
	public void visualizar()
	{
		String cmd2="select * from funcionario";
		try
		{
			Statement pstm2=conn.createStatement();
			ResultSet rs=pstm2.executeQuery(cmd2);
			while(rs.next())
			{
				int ida=rs.getInt(1);
				String name=rs.getString(2);
				String car=rs.getString(3);
				int s=rs.getInt(4);
				System.out.println("Id: "+ida+"Name: "+name+"car: "+car);
				
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQL State "+e.getSQLState());
			System.out.println("Mensagem"+e.getMessage());
		}
	}
}
