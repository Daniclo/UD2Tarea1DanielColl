package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejer2 {
    public static void main(String[] args) {
        //Conectar con base de datos oracle.
        try {
            //Tendríamos que cambiar jdbc:mysql por jdbc:oracle:thin. Sin embargo, tendríamos que utilizar
            // otro driver JDBC distinto, tal y como nos indica la excepción que salta (no suitable driver found).
            Connection con = DriverManager.getConnection("jdbc:oracle:thin://localhost/ada","root","daniel");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}