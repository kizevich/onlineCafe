package by.itstep.cafe.controller.impl;

import by.itstep.cafe.dao.entity.Cart;
import by.itstep.cafe.dao.entity.Product;
import by.itstep.cafe.dao.entity.ProductSet;
import by.itstep.cafe.service.CartService;
import by.itstep.cafe.service.ProductService;
import by.itstep.cafe.service.ProductSetService;
import by.itstep.cafe.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/", ""})
public class MainControllerImpl {

    private ProductService productService;
    private CartService cartService;
    private UserService userService;
    private ProductSetService productSetService;

    public MainControllerImpl(ProductService productService, CartService cartService,
                              ProductSetService productSetService, UserService userService) {
        this.userService = userService;
        this.cartService = cartService;
        this.productService = productService;
        this.productSetService = productSetService;
    }

    @GetMapping()
    public String index() {
        return "mainPage";
    }

    @PostMapping("menu/")
    public String showMenu(@RequestParam("cartId") String cartId, Cart cart, Model model) throws Exception{
        model.addAttribute("products", productService.listProducts());
        model.addAttribute("cart", cart);
        model.addAttribute("productSets", productSetService.findByCartId(cart.getId()));

        System.out.println("showMenu:" + cart.getId());
        System.out.println(cartId);

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
