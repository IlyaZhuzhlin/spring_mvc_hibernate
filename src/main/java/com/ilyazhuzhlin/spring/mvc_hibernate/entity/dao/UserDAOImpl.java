package com.ilyazhuzhlin.spring.mvc_hibernate.entity.dao;

import com.ilyazhuzhlin.spring.mvc_hibernate.entity.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("Select U from User U", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public void updateUser(User user, int id) {
        User user1 = getUser(id);
        user1.setName(user.getName());
        user1.setSurname(user.getSurname());
        user1.setDepartment(user.getDepartment());
        user1.setAge(user.getAge());
        entityManager.merge(user1);
    }
}