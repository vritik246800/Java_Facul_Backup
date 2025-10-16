import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;


public class TestaOracle {
    public static void main(String[] args) {
    	TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        // ALTERA para o IP da tua VM
        String host = "10.108.252.179";
        String port = "1521";
        String sid  = "XE"; // SID do Oracle XE
        String url = "jdbc:oracle:thin:@" + host + ":" + port + ":" + sid;

        String user = "E2019";       // usuário Oracle
        String password = "2002"; // substitui pela password real

        Connection conn = null;
        try {
            // Carrega o driver Oracle JDBC
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Tenta conectar
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(" Conectado com sucesso ao Oracle!");

        } catch (ClassNotFoundException e) {
            System.out.println(" Driver JDBC Oracle não encontrado!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(" Falha ao conectar no Oracle:");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
