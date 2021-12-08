package by.itstep.cafe.service.impl;

import by.itstep.cafe.dao.repository.ProductDao;
import by.itstep.cafe.dao.entity.Product;
import by.itstep.cafe.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public ProductServiceImpl (ProductDao productDao) {
        this.productDao = productDao;
    }


    @Override
    public Product addProduct(Product product) {
        return productDao.save(product);
    }

    @Override
    public void removeProduct(int id) {
        productDao.deleteById(id);
    }

    @Override
    public List<Product> listProducts() {
        return productDao.findAll();
    }

    @Override
    public Product getProduct(String name) {
        return productDao.findByName(name);
    }
}
