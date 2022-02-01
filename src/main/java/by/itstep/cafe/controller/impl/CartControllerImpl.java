package by.itstep.cafe.controller.impl;

import by.itstep.cafe.controller.CartController;
import by.itstep.cafe.dao.entity.Cart;
import by.itstep.cafe.dao.entity.User;
import by.itstep.cafe.service.CartService;
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

@Controller
@RequestMapping({"/cart"})
public class CartControllerImpl implements CartController {

    private CartService cartService;
    private UserService userService;

    public CartControllerImpl(CartService cartService, UserService userService) {
        this.userService = userService;
        this.cartService = cartService;
    }

    @GetMapping("/new")
    public String newOrder(Model model) {
        model.addAttribute("user", new User());
        return "cart/new";
    }

    @PostMapping("/createOrder")
    public String menu(@RequestParam("userId") String userId, Model model) throws Exception {
        Cart cart = new Cart();
        cart.setClient(userService.findById(Integer.parseInt(userId)));
        cart.setFullPrice(BigDecimal.ZERO);
        cart.setCreateDate(LocalDateTime.now());
        cart.setState("new");
        cartService.save(cart);
        model.addAttribute("cartId", cart.getId());

        System.out.println("menu:" + cart.getId());

        return "redirect:/menu/";
    }

    @PostMapping("/confirmCart")
    public void confirmCart(@RequestParam("cartId") String cartId, Model model) throws Exception {
        Cart cart = cartService.getById(Integer.parseInt(cartId));
        model.addAttribute("cart", cartService.confirmCart(cart));
    }

    @Override
    public Cart addOrder(Cart cart) {
        return cartService.save(cart);
    }

    @Override
    public void removeOrder(int id) {
        cartService.removeOrder(id);
    }

    @Override
    public List<Cart> listOrders() {
        return cartService.listOrders();
    }



    @Override
    public List findAllOrdersByUserName(String name) {
        return cartService.findAllOrdersByUserName(name);
    }
}
