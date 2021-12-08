package by.itstep.cafe.service.impl;

import by.itstep.cafe.dao.entity.Order;
import by.itstep.cafe.dao.repository.UserDao;
import by.itstep.cafe.dao.entity.User;
import by.itstep.cafe.service.OrderService;
import by.itstep.cafe.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static by.itstep.cafe.Utils.*;

@Service
public class UserServiceImpl implements UserService {


    private final UserDao userDao;
    private OrderService orderService;


    public UserServiceImpl(UserDao userDao, OrderService orderService) {
        this.userDao = userDao;
        this.orderService = orderService;
    }
// java docs

    @Override
    public User createUser(User user) throws Exception {
        isValid(user);
        return userDao.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteById(id);
    }

    @Override
    public List<User> listUsers() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findUserByName(String name) {
        return userDao.findUserByUserName(name);
    }

    // orderService
    @Override
    public List<Order> findAllOrdersByUserName(String name) {
        return findUserByName(name).getOrders();
    }

    @Override
    public List<Order> findAllOrderByDate(String date) {
        return orderService.getOrdersByDate(date);
    }

    @Override
    public int getDiscountByUserName(String name) {
        return findUserByName(name).getStatus().getDiscount();
    }
//TODO make void, create new exception class
    private boolean isValid(User user) throws Exception {
        boolean valid = false;
        if (isPhone(user.getPhone())) {
            valid = true;
        } else {
            throw new Exception("not correct phone number");
        }
        if (isLogin(user.getUserName())) {
            valid = true;
        } else {
            throw new Exception("not correct userName");
        }
        return valid;
    }
}
