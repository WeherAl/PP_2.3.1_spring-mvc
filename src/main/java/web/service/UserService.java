package web.service;


import web.models.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

    User getUserById (int id);
}