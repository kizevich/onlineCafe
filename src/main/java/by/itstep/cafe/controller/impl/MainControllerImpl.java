package by.itstep.cafe.controller.impl;

import by.itstep.cafe.dao.entity.Cart;
import by.itstep.cafe.dao.entity.Product;
import by.itstep.cafe.dao.entity.ProductSet;
import by.itstep.cafe.service.OrderService;
import by.itstep.cafe.service.ProductService;
import by.itstep.cafe.service.ProductSetService;
import by.itstep.cafe.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", ""})
public class MainControllerImpl {

    private ProductService productService;
    private OrderService orderService;
    private UserService userService;
    private ProductSetService productSetService;

    public MainControllerImpl(ProductService productService, OrderService orderService,
                              ProductSetService productSetService, UserService userService) {
        this.userService = userService;
        this.orderService = orderService;
        this.productService = productService;
        this.productSetService = productSetService;
    }

    @GetMapping()
    public String index() {
        return "mainPage";
    }

    @GetMapping("menu/")
    public String showMenu(Cart cart, Model model){
        model.addAttribute("products", productService.listProducts());
        model.addAttribute("cart", cart);
        model.addAttribute("productSets", productSetService.findByCartId(cart.getId()));

        System.out.println("showMenu:" + cart.getId());

        return "mainPage/menu";
    }

    @GetMapping("menu/productSet/new/{id}")
    public String createProductSet(Cart cart, @PathVariable("id") int id, Model model) throws Exception {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("productSet", new ProductSet());
        model.addAttribute("cart", cart);

        System.out.println("createProductSet:" + cart.getId());

        return "productSet/new";
    }



}
