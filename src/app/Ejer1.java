package app;

import java.sql.*;
import java.util.Properties;
public class Ejer1 {
    public static void main(String[] args) {
        try {
            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/ada","root","daniel");
            //Las conexiones 2 y 3 no funcionan porque no tienen usuario y contraseña.
            Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/ada");
            Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost/ada", new Properties());
            Statement st1 = con1.createStatement();
            Statement st2 = con2.createStatement();
            Statement st3 = con3.createStatement();
            ResultSet rs1 = st1.executeQuery("select id from login");
            ResultSet rs2 = st2.executeQuery("select username from login");
            ResultSet rs3 = st3.executeQuery("select password from login");
            while (rs1.next()){
                System.out.println(rs1.getInt("id"));
            }
            while (rs2.next()){
                System.out.println(rs2.getString("username"));
            }
            while (rs3.next()){
                System.out.println(rs3.getString("password"));
            }
        } catch (SQLException e) {
            System.err.println(e.getSQLState()+" "+e.getMessage());
        }
    }
}