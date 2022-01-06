package by.itstep.cafe.service.impl;

import by.itstep.cafe.dao.entity.ProductSet;
import by.itstep.cafe.dao.repository.ProductSetDao;
import by.itstep.cafe.service.ProductSetService;
import org.springframework.stereotype.Service;

@Service
public class ProductSetServiceImpl implements ProductSetService {

    private ProductSetDao productSetDao;

    public ProductSetServiceImpl(ProductSetDao productSetDao) {
        this.productSetDao = productSetDao;
    }

    @Override
    public ProductSet save(ProductSet productSet) {
        return productSetDao.save(productSet);
    }

    @Override
    public void removeProductSet(int id) {

        productSetDao.deleteById(id);
    }

    @Override
    public ProductSet findByOrderId(int id) {
        return productSetDao.findByOrderId(id);
    }
}
