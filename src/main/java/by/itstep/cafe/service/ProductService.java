package by.itstep.cafe.service;

import by.itstep.cafe.dao.entity.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    void removeProduct(int id);

    List<Product> listProducts();

    Product getByName(String name) throws Exception;

    Product findById(int id) throws Exception;

    List<Product> findAllById(List<Integer> ids);
}
