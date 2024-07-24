package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public List<User> listUsers() {

        String jpql = "select u from User u";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);

        return query.getResultList();
    }

    @Override
    public void deleteUserById(int id) {
        User user = entityManager.find(User.class, id);

        entityManager.remove(user);
    }

    @Override
    public User findById(int id) {
       return entityManager.find(User.class, id);
    }

}
