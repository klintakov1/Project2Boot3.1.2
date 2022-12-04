package ru.klintakov.springcourse.Project2Boot.dao;


import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.klintakov.springcourse.Project2Boot.entity.User;

import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager entityManager;
@Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<User> getAllUsers() { // получить всех пользователей
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) { // сохранить пользователя
        entityManager.persist(user);
    }

    @Override
    public User getUser(long id) { //получить пользователя
        return entityManager.find(User.class,id);
    }

    @Override
    public void deleteUser(long id) { // удаляем пользователя
        User user = entityManager.find(User.class,id);
        entityManager.remove(user);

    }

    @Override
    public void updateUser(User user) {//обновление пользователей
        entityManager.merge(user);

    }
}