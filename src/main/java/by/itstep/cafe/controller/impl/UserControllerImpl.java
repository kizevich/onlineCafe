package by.itstep.cafe.controller.impl;


import by.itstep.cafe.controller.UserController;
import by.itstep.cafe.dao.entity.User;
import by.itstep.cafe.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

    private UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "user/index";
    }


    @Override
    public User createUser(User user) throws Exception {
        return userService.createUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userService.deleteUser(id);
    }

    @Override
    public List listUsers() {
        return userService.listUsers();
    }

    @Override
    public User findUserByName(String name) {
        return userService.findUserByName(name);
    }

    @Override
    public List findAllOrdersByUserName(String name) {
        return userService.findAllOrdersByUserName(name);
    }

    @Override
    public List findAllOrderByDate(String date) {
        return userService.findAllOrderByDate(date);
    }

    @Override
    public int getDiscountByUserName(String name) {
        return userService.getDiscountByUserName(name);
    }
}
