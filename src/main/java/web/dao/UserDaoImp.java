package web.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.models.User;
import web.util.Util;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    Util util;

    @Autowired
    UserDaoImp(Util util) {
        this.util = util;
    }

    @Override
    public void createUsersTable() {

        try (Session session = util.getFactory().getCurrentSession()) {
            session.beginTransaction();


            String sql = "CREATE TABLE IF NOT EXISTS users " + "(id int NOT NULL AUTO_INCREMENT PRIMARY KEY, " + "name VARCHAR(50) NOT NULL, lastName VARCHAR(50) NOT NULL, " + "age int NOT NULL)";

            Query query = session.createSQLQuery(sql).addEntity(User.class);

            query.executeUpdate();


            session.getTransaction().commit();
        }

    }

    @Override
    public void dropUsersTable() {

        try (Session session = util.getFactory().getCurrentSession()) {
            session.beginTransaction();

            String sql = "DROP TABLE IF EXISTS users";

            Query query = session.createSQLQuery(sql).addEntity(User.class);

            query.executeUpdate();


            session.getTransaction().commit();
        }


    }

    @Override
    public void saveUser(User user) {

        try (Session session = util.getFactory().getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(user);
            System.out.println("User с именем – " + user.getName() + " добавлен в базу данных");
            session.getTransaction().commit();
        }

    }

    @Override
    public void removeUserById(long id) {

        try (Session session = util.getFactory().getCurrentSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
                System.out.println("Пользователь с id " + id + " успешно удален");

            } else {
                System.out.println("Пользователя с id: " + id + " не существует");
            }
            session.getTransaction().commit();
        }
    }


    @Override
    public List<User> getAllUsers() {

        try (Session session = util.getFactory().getCurrentSession()) {
            session.beginTransaction();
            List<User> userList = session.createQuery("from Users").getResultList();
            session.getTransaction().commit();

            return userList;

        }

    }

    @Override
    public void cleanUsersTable() {

        try (Session session = util.getFactory().getCurrentSession()) {

            session.beginTransaction();
            session.createQuery("delete Users").executeUpdate();
            System.out.println("Таблица пользователей успешно очищена");
            session.getTransaction().commit();
        }
    }

    @Override
    public User getUserById(int id) {

        try (Session session = util.getFactory().getCurrentSession()) {
            session.beginTransaction();
            User user = session.get(User.class, (long) id);
            session.getTransaction().commit();
            return user;
        }

    }


}