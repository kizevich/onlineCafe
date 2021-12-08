package by.itstep.cafe.controller;

import by.itstep.cafe.dao.entity.Product;

import java.util.List;

public interface ProductController {

    Product addProduct(Product product);

    void removeProduct(int id);

    List<Product> listProducts();

    Product getProduct(String name);
}
