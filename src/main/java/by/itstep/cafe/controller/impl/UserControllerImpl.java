package by.itstep.cafe.controller.impl;


import by.itstep.cafe.controller.UserController;
import by.itstep.cafe.dao.entity.User;
import by.itstep.cafe.service.RoleService;
import by.itstep.cafe.service.StatusService;
import by.itstep.cafe.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

    private UserService userService;
    private RoleService roleService;
    private StatusService statusService;

    public UserControllerImpl(UserService userService, RoleService roleService, StatusService statusService) {
        this.roleService = roleService;
        this.userService = userService;
        this.statusService = statusService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.listUsers());

        return "user/index";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.listRoles());

        return "user/new";
    }

    @PostMapping()
    public String create(User user, @RequestParam("id") int id, Model model) throws Exception {
        user.setRole(roleService.findById(id));
        user.setStatus(statusService.findById(1));
        userService.save(user);

        return "redirect:/user";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);

        return "redirect:/user";
    }

    @GetMapping("edit/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("roles", roleService.listRoles());
        model.addAttribute("statuses", statusService.listStatuses());
        User user = userService.findById(id);
        model.addAttribute("user", user);

        return "user/edit";
    }

    @PostMapping("/edit")
    public String updateUser(User user, @RequestParam("role.id") int roleId, @RequestParam("status.id") int statusId) throws Exception {
        user.setRole(roleService.findById(roleId));
        user.setStatus(statusService.findById(statusId));
        userService.save(user);

        return "redirect:/user";
    }


    @Override
    public User createUser(User user) throws Exception {
        return userService.save(user);
    }

    @Override
    public List listUsers() {
        return userService.listUsers();
    }

    @Override
    public User findUserByName(String name) throws Exception {

        return userService.findUserByName(name);
    }

    @Override
    public int getDiscountByUserName(String name) throws Exception {
        return userService.getDiscountByUserName(name);
    }
}
