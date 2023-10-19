package mysql;

import model.Login;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Los métodos que realizan cosas en la base de datos con la tabla en el nombre.
 */
public class LoginHandleDB {

    public static List<Login> getLogins(){
        String selectSQL = "select * from login";
        ArrayList<Login> logins = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(selectSQL);

            while (rs.next()){
                Login login = new Login();
                login.setId(rs.getInt("id"));
                login.setUsername(rs.getString("username"));
                login.setPassword(rs.getString("password"));
                //Las fechas me estaban dando problemas a la hora de probar cosas así que he omitido su uso para la práctica.
                //login.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                logins.add(login);
            }

        } catch (SQLException e) {
            System.err.println(e.getSQLState() + " " + e.getMessage());
        }
        return logins;
    }

    public static Login getLogin(String name, String password){
        Login login = new Login();
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from login where username=? and password=?");
            st.setString(1,name);
            st.setString(2,password);
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                login = new Login();
                login.setId(rs.getInt("id"));
                login.setUsername(rs.getString("username"));
                login.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.err.println(e.getSQLState() + " " + e.getMessage());
        }
        return login;
    }
    public static Login getLogin(long id) {
        Login login = new Login();
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from login where id=?");
            st.setLong(1,id);
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                login.setId(rs.getInt("id"));
                login.setUsername(rs.getString("username"));
                login.setPassword(rs.getString("password"));
            }

        } catch (SQLException e) {
            System.err.println(e.getSQLState() + " " + e.getMessage());
        }
        return login;
    }
    public static int addLogin(Login login){
        List<Login> logins = getLogins();
        long lastID =logins.getLast().getId() + 1;
        login.setId(lastID);
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into login(id,username,password) values (?, ?, ?)");
            ps.setLong(1,login.getId());
            ps.setString(2,login.getUsername());
            ps.setString(3,login.getPassword());
            ps.execute();

        } catch (SQLException e) {
            System.err.println(e.getSQLState() + " " + e.getMessage());
        }
        System.out.println("Se ha añadido el usuario con ID: " + login.getId());
        return (int) lastID;
    }
    public static void deleteLogin(long id){
        try{
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement st = conn.prepareStatement("delete from login where id=?");
            st.setLong(1,id);
            st.execute();
            System.out.println("Login eliminado con la id " + id);
        } catch (SQLException e) {
            System.err.println(e.getSQLState() + " " + e.getMessage());
        }
    }
    public static void updateLogin(Login login){
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement st = conn.prepareStatement("update login set username=?, password=? where id=?");
            st.setString(1, login.getUsername());
            st.setString(2, login.getPassword());
            st.setLong(3,login.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getSQLState() + " " + e.getMessage());
        }
        System.out.println("Actualizado el login con id: " + login.getId());
    }
}