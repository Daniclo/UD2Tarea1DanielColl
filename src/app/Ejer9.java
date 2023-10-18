package app;

import model.Login;
import mysql.LoginHandleDB;
import java.util.List;

public class Ejer9 {
    public static void main(String[] args) {
        List<Login> logins = LoginHandleDB.getLogins();
        System.out.println("Lista de logins:");
        logins.forEach(System.out::println);
        Login checkLogin = LoginHandleDB.getLogin(4);
        System.out.println("\nLogin encontrado: " + checkLogin);
    }
}
