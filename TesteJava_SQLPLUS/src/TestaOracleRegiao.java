import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;

public class TestaOracleRegiao {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

        String host = "10.108.252.179";
        String port = "1521";
        String sid  = "XE";
        String url = "jdbc:oracle:thin:@" + host + ":" + port + ":" + sid;

        String user = "E2019";       
        String password = "2002";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Conectado com sucesso ao Oracle!");

            // Cria statement
            stmt = conn.createStatement();

            // Executa query
            rs = stmt.executeQuery("SELECT DATA_NASC FROM LEITOR");

            // Itera pelo resultado
            System.out.println("REGIAO_ID | REG_NOME");
            System.out.println("----------------------");
            while (rs.next()) {
                //int id = rs.getInt("REGIAO_ID");
                String nome = rs.getString("DATA_NASC");
                System.out.println(nome);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver JDBC Oracle não encontrado!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Falha ao executar query:");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
