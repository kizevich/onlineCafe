package by.itstep.cafe.controller;

import by.itstep.cafe.dao.entity.Cart;
import by.itstep.cafe.dao.entity.Product;
import by.itstep.cafe.dao.entity.ProductSet;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductSetController {


    String save(Product product, Cart cart, ProductSet productSet, Model model) throws Exception;

    String delete(int id, Cart cart, Model model);
}
