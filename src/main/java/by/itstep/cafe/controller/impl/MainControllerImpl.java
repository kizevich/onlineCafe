package by.itstep.cafe.controller.impl;

import by.itstep.cafe.dao.entity.Order;
import by.itstep.cafe.dao.entity.User;
import by.itstep.cafe.service.OrderService;
import by.itstep.cafe.service.ProductService;
import by.itstep.cafe.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Controller
@RequestMapping({"/", ""})
public class MainControllerImpl {

    private ProductService productService;
    private OrderService orderService;
    private UserService userService;

    public MainControllerImpl(ProductService productService, OrderService orderService, UserService userService) {
        this.userService = userService;
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping()
    public String index() {
        return "mainPage";
    }

    @GetMapping("menu/")
    public String showMenu(Model model){
        model.addAttribute(productService.listProducts());

        return "mainPage/menu";
    }



}
