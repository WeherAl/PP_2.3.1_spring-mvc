package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoJpaIm implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserById(int id) {
        TypedQuery<User> u = entityManager.createQuery("SELECT u FROM Users u WHERE u.id = :id", User.class);
        u.setParameter("id", id);
        return u.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUserById(long id) {
        User user = getUserById((int) id);
        entityManager.remove(user);
    }


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM Users u", User.class).getResultList();
    }



}
