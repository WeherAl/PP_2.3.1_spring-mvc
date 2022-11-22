package web.dao;


import web.models.User;

import java.util.List;

public interface UserDao {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();

    User getUserById (int id);
}