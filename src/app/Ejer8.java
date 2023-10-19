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
        LoginHandleDB.updateLogin(login);
        System.out.println(login);
    }
}