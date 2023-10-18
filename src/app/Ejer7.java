package app;

import model.Login;
import mysql.LoginHandleDB;
import java.util.List;

public class Ejer7 {
    public static void main(String[] args) {
        List<Login> logins = LoginHandleDB.getLogins();
        logins.forEach(System.out::println);
        LoginHandleDB.deleteLogin(2);
        List<Login> newLogins = LoginHandleDB.getLogins();
        newLogins.forEach(System.out::println);
    }
}
