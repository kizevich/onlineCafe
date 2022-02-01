package by.itstep.cafe.service.impl;

import by.itstep.cafe.dao.repository.UserDao;
import by.itstep.cafe.dao.entity.User;
import by.itstep.cafe.service.CartService;
import by.itstep.cafe.service.StatusService;
import by.itstep.cafe.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static by.itstep.cafe.Utils.*;

@Service
public class UserServiceImpl implements UserService {


    private final UserDao userDao;
    private StatusService statusService;


    public UserServiceImpl(UserDao userDao, StatusService statusService) {
        this.userDao = userDao;
        this.statusService = statusService;
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
    public User findById(int id) throws Exception {
        Optional<User> optionalUser = userDao.findById(id);

        if (optionalUser.isPresent()){
            User user = optionalUser.get();

            return user;
        } else {
            throw new Exception("user is not exist");
        }
    }


    @Override
    public int getDiscountByUserId(int id) throws Exception {
        User user = findById(id);

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
