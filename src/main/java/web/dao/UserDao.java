package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    User updateUser(User user);
    List<User> listUsers();
    void deleteUserById(int id);
    User findById (int id);
}
