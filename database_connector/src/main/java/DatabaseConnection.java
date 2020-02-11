import java.sql.*;

// JDBC     -> java database connector
// mysql    -> silnik interpretera
public class DatabaseConnection {
    private String url = "jdbc:mysql://remotemysql.com:3306/lnuCMNEYTL";
    private String username = "lnuCMNEYTL";
    private String password = "vfJaJpLReH";
    private Connection connection;

    public void connectToDatabase() throws SQLException {
        // metoda statyczna z klasy DriverMananger pochodzącej z java-connector
        // -> zwraca obiekt połączenia klasy Connection
        Connection connection = DriverManager.getConnection(url, username, password);
        if(connection != null){
            System.out.println("... połączono z bazą danych ...");
        } else {
            System.out.println("... nie połączono z bazą danych ...");
        }
        this.connection = connection;
    }
    // metoda pobierająca i wypisująca na konsoli wszystkich praowników
    public void getAllEmployees() throws SQLException {
        String sql = "SELECT * FROM employee";
        // przygotowanie zapytania SQL
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // wykonanie zapytania -> zwracającego rezultat i nie wprowadzającego zmian w DB
        ResultSet resultSet = preparedStatement.executeQuery();
        // ResultSet to tablica 2D
        while (resultSet.next()){
            System.out.println("Pracownik nr: " + resultSet.getInt(1));
            System.out.println("Imię: " + resultSet.getString(2));
            System.out.println("Nazwisko: " + resultSet.getString(3));
            System.out.println("Pensja netto: " + resultSet.getDouble(4));
            System.out.println("==================================================");
        }
    }

    public static void main(String[] args) throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.connectToDatabase();
        databaseConnection.getAllEmployees();
    }
}
