package lazyfood.demo.models.BO;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import lazyfood.demo.models.Bean.User;
import lazyfood.demo.models.DAO.UserDAO;

public class UserBO {
    private UserDAO userDAO;

    public UserBO() {
        userDAO = new UserDAO();
    }

    public User getUserById(String id) throws SQLException {
        return userDAO.getUserById(id);
    }

    public User getUserByUsername(String username) throws SQLException {
        return userDAO.getUserByUsername(username);
    }

    public void addUser(User user) throws SQLIntegrityConstraintViolationException, SQLException {
        if (userDAO.getUserByUsername(user.getUsername()) != null)
            throw new SQLIntegrityConstraintViolationException("Username already exists");
        userDAO.addUser(user);
    }
}
