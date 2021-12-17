package by.itstep.cafe.service;

import by.itstep.cafe.dao.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user) throws Exception;

    void deleteUser(int id);

    List<User> listUsers();

    User findUserByName(String name) throws Exception;

    User findById(int id);

    int getDiscountByUserName(String name) throws Exception;
}
