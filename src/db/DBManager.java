package db;

import factory.UserFactory;
import model.User;

import java.sql.*;
import java.util.List;

public class DBManager {
    static final String DB_URL = "jdbc:mysql://localhost/UsersJavaServlet";

    //  Database credentials
    static final String USER = "username";
    static final String PASS = "password";

    private ResultSet executeStatement(String query) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.close();
            stmt.close();
            conn.close();
            return rs;
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
        return  null;
    }

    public List<User> listUsers() {
        String sql = "SELECT * from users";
        ResultSet rs = executeStatement(sql);
        UserFactory userFactory = new UserFactory();
        return userFactory.createUsersListFromResultSet(rs);
    }

    public boolean addUser(User userToAdd) {
        String sql = "INSERT INTO users(name, password, email) VALUES "
                + userToAdd.getName() + ","
                + userToAdd.getPassword() + ","
                + userToAdd.getEmail() + ";";
        executeStatement(sql);
        return true;
    }
}
