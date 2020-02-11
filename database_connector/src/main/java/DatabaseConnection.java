import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// JDBC     -> java database connector
// mysql    -> silnik interpretera
public class DatabaseConnection {
    private String url = "jdbc:mysql://remotemysql.com:3306/lnuCMNEYTL";
    private String username = "lnuCMNEYTL";
    private String password = "vfJaJpLReH";

    public Connection connectToDatabase() throws SQLException {
        // metoda statyczna z klasy DriverMananger pochodzącej z java-connector
        // -> zwraca obiekt połączenia klasy Connection
        Connection connection = DriverManager.getConnection(url, username, password);
        if(connection != null){
            System.out.println("... połączono z bazą danych ...");
        } else {
            System.out.println("... nie połączono z bazą danych ...");
        }
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.connectToDatabase();
    }
}
