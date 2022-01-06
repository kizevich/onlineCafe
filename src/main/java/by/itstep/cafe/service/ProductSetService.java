package by.itstep.cafe.service;

import by.itstep.cafe.dao.entity.ProductSet;

public interface ProductSetService {

    ProductSet save(ProductSet productSet);

    void removeProductSet(int id);

    ProductSet findByOrderId(int id);
}
