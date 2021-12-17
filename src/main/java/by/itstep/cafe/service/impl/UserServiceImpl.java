package by.itstep.cafe.service.impl;

import by.itstep.cafe.dao.entity.Order;
import by.itstep.cafe.dao.repository.UserDao;
import by.itstep.cafe.dao.entity.User;
import by.itstep.cafe.service.OrderService;
import by.itstep.cafe.service.StatusService;
import by.itstep.cafe.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static by.itstep.cafe.Utils.*;

@Service
public class UserServiceImpl implements UserService {


    private final UserDao userDao;
    private OrderService orderService;
    private StatusService statusService;


    public UserServiceImpl(UserDao userDao, OrderService orderService) {
        this.userDao = userDao;
        this.orderService = orderService;
    }
// java docs

    @Override
    public User save(User user) throws Exception {
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
    public User findUserByName(String name) throws Exception {
        Optional<User> optionalUser = userDao.findUserByUserName(name);

        if (optionalUser.isPresent()){
            User user = optionalUser.get();

            return user;
        } else {
            throw new Exception("user is not exist");
        }
    }

    @Override
    public User findById(int id) {

        return userDao.findById(id).get();
    }


    @Override
    public int getDiscountByUserName(String name) throws Exception {

        User user = findUserByName(name);

        return statusService.getDiscountById(user.getStatus().getId());
    }
//TODO make void, create new exception class
    private void isValid(User user) throws Exception {
        if (!isPhone(user.getPhone())) {
            throw new Exception("not correct phone number");
        }
        if (!isLogin(user.getUserName())) {
            throw new Exception("not correct userName");
        }
    }
}
