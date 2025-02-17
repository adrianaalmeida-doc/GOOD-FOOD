package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtil {
    private static ConexaoUtil conexaoUtil;

    public static ConexaoUtil getInstance(){
        if (conexaoUtil == null){
            conexaoUtil = new ConexaoUtil();
        }
        return conexaoUtil;
    }
    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/goodfood";
        String usuario = "root";
        String password = "";
        return DriverManager.getConnection(url,usuario,password);
    }
    public static void main(String[] args) {
        try {
            System.out.println(getInstance().getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
