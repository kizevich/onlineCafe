package by.itstep.cafe.service;

import by.itstep.cafe.dao.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user) throws Exception;

    void deleteUser(int id);

    List listUsers();

    Optional<User> findUserByName(String name);

    List findAllOrdersByUserName(String name);

    List findAllOrderByDate(String date);

    int getDiscountByUserName(String name);
}
