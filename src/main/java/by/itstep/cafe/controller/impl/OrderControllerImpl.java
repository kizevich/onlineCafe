package by.itstep.cafe.controller.impl;

import by.itstep.cafe.controller.OrderController;
import by.itstep.cafe.dao.entity.Cart;
import by.itstep.cafe.dao.entity.User;
import by.itstep.cafe.service.OrderService;
import by.itstep.cafe.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"/cart"})
public class OrderControllerImpl implements OrderController {

    private OrderService orderService;
    private UserService userService;

    public OrderControllerImpl(OrderService orderService, UserService userService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping("/new")
    public String newOrder(Model model) {
        model.addAttribute("user", new User());
        return "cart/new";
    }

    @PostMapping("/createOrder")
    public String menu(User user, Model model) throws Exception {
        Cart cart = new Cart();
        cart.setClient(userService.findUserByName(user.getUserName()));
        cart.setFullPrice(BigDecimal.ZERO);
        cart.setCreateDate(LocalDateTime.now());
        cart.setState("new");
        orderService.save(cart);
        model.addAttribute("cartId", cart.getId());

        System.out.println("menu:" + cart.getId());

        return "redirect:/menu/";
    }

    @Override
    public Cart addOrder(Cart cart) {
        return orderService.save(cart);
    }

    @Override
    public void removeOrder(int id) {
        orderService.removeOrder(id);
    }

    @Override
    public List<Cart> listOrders() {
        return orderService.listOrders();
    }

    @Override
    public List findAllOrdersByUserName(String name) {
        return orderService.findAllOrdersByUserName(name);
    }
}
