package by.itstep.cafe.controller.impl;

import by.itstep.cafe.controller.ProductSetController;
import by.itstep.cafe.dao.entity.Cart;
import by.itstep.cafe.dao.entity.Product;
import by.itstep.cafe.dao.entity.ProductSet;
import by.itstep.cafe.service.CartService;
import by.itstep.cafe.service.ProductService;
import by.itstep.cafe.service.ProductSetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productSet")
public class ProductSetControllerImpl implements ProductSetController {

    private ProductSetService productSetService;
    private CartService cartService;
    private ProductService productService;

    public ProductSetControllerImpl(ProductSetService productSetService, CartService cartService, ProductService productService) {
        this.productSetService = productSetService;
        this.cartService = cartService;
        this.productService = productService;
    }

    @PostMapping("/save/")
    public String save(Product product, Cart cart, ProductSet productSet, Model model) throws Exception {

        System.out.println(cart.getId());

        productSet.setCart(cartService.getByState("new"));
        productSet.setProduct(productService.findById(product.getId()));

        productSetService.save(productSet);

        model.addAttribute("cart", cart);

        return "redirect:/menu/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Cart cart, Model model) {
        productSetService.removeProductSet(id);

        model.addAttribute("cart", cart);

        return "redirect:/menu/";
    }

}
