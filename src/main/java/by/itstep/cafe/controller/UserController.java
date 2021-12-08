package by.itstep.cafe.controller;

import by.itstep.cafe.dao.entity.User;

import java.util.List;

public interface UserController {

    User createUser(User user) throws Exception;

    void deleteUser(int id);

    List listUsers();

    User findUserByName(String name);

    List findAllOrdersByUserName(String name);

    List findAllOrderByDate(String date);

    int getDiscountByUserName(String name);

}
