package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDaoJpaIm;
import web.models.User;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    private UserDaoJpaIm userDaoJpaIm;

    @Autowired
    private UserServiceImp(UserDaoJpaIm userDaoJpaIm) {

        this.userDaoJpaIm = userDaoJpaIm;
    }

    @Override
    @Transactional
    public void saveUser(User user) {

        userDaoJpaIm.saveUser(user);
    }

    @Override
    @Transactional
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