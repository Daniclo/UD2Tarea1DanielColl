package app;

import model.Login;
import mysql.LoginHandleDB;
import java.util.List;

public class Ejer5 {
    public static void main(String[] args) {
        List<Login> logins = LoginHandleDB.getLogins();
        logins.forEach(System.out::println);
        Login checkLogin = LoginHandleDB.getLogin("daniel","coll");
        System.out.println("\nLogin encontrado: " + checkLogin);
    }
}