package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 *Patrones de diseño:
 * Singleton (antipatrón) solo permite una instancia del objeto.
 *
 */
public class DatabaseConnection {
    private static Connection conn;

    static {
        String user = "root";
        String password = "daniel";
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/ada",user,password);
        } catch (SQLException e) {
            System.err.println("Ha habido un error en la conexión");
        }
    }
    private DatabaseConnection(){};

    public static Connection getConnection() {
        return conn;
    }
    public static void closeConnection() throws SQLException {
        conn.close();
    }
}