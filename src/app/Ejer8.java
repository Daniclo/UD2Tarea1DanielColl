package app;

import model.Login;
import mysql.LoginHandleDB;
import util.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Ejer8 {
    public static void main(String[] args) {
        List<Login> logins = LoginHandleDB.getLogins();
        Login login = logins.get(0);
        System.out.println(login);
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate("update login set username='aaa', password='bbb' where id=1");
        } catch (SQLException e) {
            System.err.println(e.getSQLState() + " " + e.getMessage());
        }
        LoginHandleDB.updateLogin(login);
        System.out.println(login);
    }
}
