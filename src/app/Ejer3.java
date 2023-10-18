package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejer3 {
    public static void main(String[] args) {
        try {
            //Class.forName("com.mysql.jdbc.Driver"); Esta versión (la que pone en el enunciado) está deprecada. Ahora se
            //usa esta otra:
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ada","root","daniel");
            //Class.forName sirve para cargar en esta clase el Driver del jdbc y poder utilizarlo para establecer una
            //conexión. Sin embargo, esto, que antes era obligatorio, ahora se realiza de forma automática desde JDK6 y
            //es por eso que no lo hemos utilizado.
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (SQLException e) {
            System.err.println(e.getSQLState() + " " + e.getMessage());
        }
    }
}