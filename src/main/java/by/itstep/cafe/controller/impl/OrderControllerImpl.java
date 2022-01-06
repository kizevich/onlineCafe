package by.itstep.cafe.controller.impl;

import by.itstep.cafe.controller.OrderController;
import by.itstep.cafe.dao.entity.Order;
import by.itstep.cafe.dao.entity.User;
import by.itstep.cafe.service.OrderService;
import by.itstep.cafe.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"/order"})
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
        return "order/new";
    }

    @PostMapping("/createOrder")
    public String menu(User user, Model model) throws Exception {
        Order order = new Order();
        order.setClient(userService.findUserByName(user.getUserName()));
        order.setFullPrice(BigDecimal.ZERO);
        order.setCreateDate(LocalDateTime.now());
        order.setState("new");
        System.out.println(order.toString());
        orderService.save(order);
        model.addAttribute(order);

        return "redirect:/mainPage/menu";
    }

    @Override
    public Order addOrder(Order order) {
        return orderService.save(order);
    }

    @Override
    public void removeOrder(int id) {
        orderService.removeOrder(id);
    }

    @Override
    public List<Order> listOrders() {
        return orderService.listOrders();
    }

    @Override
    public List findAllOrdersByUserName(String name) {
        return orderService.findAllOrdersByUserName(name);
    }

    @Override
    public Optional<Order> getOrder(int id) {
        return orderService.getOrder(id);
    }
}
