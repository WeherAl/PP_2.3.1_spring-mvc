package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDaoImp;
import web.dao.UserDaoJpaIm;
import web.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    UserDaoImp userDao;
    UserDaoJpaIm userDaoJpaIm;

    @Autowired
    UserServiceImp(UserDaoImp userDaoImp, UserDaoJpaIm userDaoJpaIm) {
        this.userDao = userDaoImp;
        this.userDaoJpaIm = userDaoJpaIm;
    }

    public void createUsersTable() {
        userDao.createUsersTable();
    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
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

    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }

    @Override
    public User getUserById(int id) {
        return userDaoJpaIm.getUserById(id);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}