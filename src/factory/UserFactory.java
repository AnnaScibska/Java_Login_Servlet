package factory;

import model.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserFactory {

    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "email";

    public List<User> createUsersListFromResultSet(ResultSet resultSet) {
        List<User> users = new ArrayList<>();
        try {
            while( resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString(NAME));
                user.setEmail(resultSet.getString(EMAIL));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User createUserFromRequest(HttpServletRequest request) {
        User user = new User();
        user.setName(request.getParameter(NAME));
        user.setName(request.getParameter(EMAIL));
        user.setName(request.getParameter(PASSWORD));
        return user;
    }
}
