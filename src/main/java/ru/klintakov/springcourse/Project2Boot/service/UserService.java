package ru.klintakov.springcourse.Project2Boot.service;


import ru.klintakov.springcourse.Project2Boot.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(long id);

    public void deleteUser(long id);

    public void updateUser(User user);
}
