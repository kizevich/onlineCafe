package by.itstep.cafe.controller.impl;

import by.itstep.cafe.controller.ProductController;
import by.itstep.cafe.dao.entity.Product;
import by.itstep.cafe.dao.entity.User;
import by.itstep.cafe.service.ProductService;
import by.itstep.cafe.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductControllerImpl implements ProductController {

    private ProductService productService;
    private TypeService typeService;

    public ProductControllerImpl(ProductService productService, TypeService typeService) {
        this.typeService = typeService;
        this.productService = productService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("products", productService.listProducts());

        return "product/index";
    }

    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("types", typeService.listTypes());

        return "product/new";
    }

    @PostMapping()
    public String create(Product product, @RequestParam("id") int id, Model model) throws Exception {
        product.setType(typeService.findById(id));
        productService.save(product);

        return "redirect:/product";
    }

    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.removeProduct(id);

        return "redirect:/product";
    }

    @GetMapping("edit/{id}")
    public String updateProductForm(@PathVariable("id") int id, Model model) throws Exception {
        model.addAttribute("types", typeService.listTypes());
        Product product = productService.findById(id);
        model.addAttribute("product", product);

        return "user/edit";
    }

    @PostMapping("/edit")
    public String updateProduct(Product product, @RequestParam("type.id") int typeId) throws Exception {
        product.setType(typeService.findById(typeId));
        productService.save(product);

        return "redirect:/product";
    }

    @Override
    public Product addProduct(Product product) {
        return productService.save(product);
    }

    @Override
    public void removeProduct(int id) {
        productService.removeProduct(id);
    }

    @Override
    public List<Product> listProducts() {
        return productService.listProducts();
    }

    @Override
    public Product getProduct(String name) {
        return productService.getProduct(name);
    }
}
