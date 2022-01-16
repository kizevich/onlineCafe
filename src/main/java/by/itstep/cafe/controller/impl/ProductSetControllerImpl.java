package by.itstep.cafe.controller.impl;

import by.itstep.cafe.controller.ProductSetController;
import by.itstep.cafe.dao.entity.ProductSet;
import by.itstep.cafe.service.OrderService;
import by.itstep.cafe.service.ProductService;
import by.itstep.cafe.service.ProductSetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productSet")
public class ProductSetControllerImpl implements ProductSetController {

    private ProductSetService productSetService;
    private OrderService orderService;
    private ProductService productService;

    public ProductSetControllerImpl(ProductSetService productSetService, OrderService orderService, ProductService productService) {
        this.productSetService = productSetService;
        this.orderService = orderService;
        this.productService = productService;
    }

    @PostMapping("/{id}")
    public String save(@PathVariable("id") int id, Model model) throws Exception {
        ProductSet productSet = new ProductSet();
        productSet.setAmount(1);
        productSet.setCart(orderService.getByState("new"));
        productSet.setProduct(productService.findById(id));

        productSetService.save(productSet);

        return "redirect:/menu/";
    }
}
