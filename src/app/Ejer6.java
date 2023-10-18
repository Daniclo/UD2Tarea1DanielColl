package app;

import model.Login;
import mysql.LoginHandleDB;

import java.util.List;

public class Ejer6 {
    public static void main(String[] args) {
        Login login = new Login();
        login.setId(1);
        login.setUsername("daniel");
        login.setPassword("vital");
        int index = LoginHandleDB.addLogin(login);
        List<Login> logins = LoginHandleDB.getLogins();
        logins.forEach(System.out::println);
        System.out.println("\n" + index);
    }
}
