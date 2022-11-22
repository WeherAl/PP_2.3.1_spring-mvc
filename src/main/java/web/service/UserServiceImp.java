package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDaoJpaIm;
import web.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private UserDaoJpaIm userDaoJpaIm;

    @Autowired
    UserServiceImp(UserDaoJpaIm userDaoJpaIm) {
        this.userDaoJpaIm = userDaoJpaIm;
    }
    public void saveUser(User user) {
        userDaoJpaIm.saveUser(user);
    }

    public void removeUserById(long id) {
        userDaoJpaIm.removeUserById(id);
    }

    public List<User> getAllUsers() {

        return userDaoJpaIm.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDaoJpaIm.getUserById(id);
    }

}