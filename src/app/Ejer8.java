package app;

import model.Login;
import mysql.LoginHandleDB;
import util.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Ejer8 {
    public static void main(String[] args) {
        List<Login> logins = LoginHandleDB.getLogins();
        Login login = logins.get(0);
        System.out.println(login);
        LoginHandleDB.updateLogin(login);
        System.out.println("\nComprobación:");
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from login where id=1");
            while (rs.next()){
                System.out.println(rs.getLong("id") + " " + rs.getString("username") +
                        " " +rs.getString("password"));
            }
        } catch (SQLException e) {
            System.err.println(e.getSQLState() + " " + e.getMessage());
        }
    }
}