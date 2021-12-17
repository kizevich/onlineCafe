package by.itstep.cafe.controller;

import by.itstep.cafe.dao.entity.User;

import java.util.List;

public interface UserController {

    User createUser(User user) throws Exception;

    String deleteUser(int id);

    List<User> listUsers();

    User findUserByName(String name) throws Exception;

    int getDiscountByUserName(String name) throws Exception;

}
