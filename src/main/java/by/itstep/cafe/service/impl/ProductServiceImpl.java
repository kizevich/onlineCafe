package by.itstep.cafe.service.impl;

import by.itstep.cafe.dao.repository.ProductDao;
import by.itstep.cafe.dao.entity.Product;
import by.itstep.cafe.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl (ProductDao productDao) {
        this.productDao = productDao;
    }


    @Override
    public Product save(Product product) {
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
    public Product getByName(String name) throws Exception {
        Optional<Product> optionalProduct = productDao.findByName(name);

        if (optionalProduct.isPresent()){

            return optionalProduct.get();
        } else {
            throw new Exception("status is not exist");
        }
    }

    @Override
    public Product findById(int id) throws Exception {

        Optional<Product> optProduct = productDao.findById(id);

        if(optProduct.isPresent()){
            return optProduct.get();
        } else {
            throw new Exception();
        }
    }

    @Override
    public List<Product> findAllById(List<Integer> ids) {
        return productDao.findAllById(ids);
    }
}
