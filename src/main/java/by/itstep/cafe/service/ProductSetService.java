package by.itstep.cafe.service;

import by.itstep.cafe.dao.entity.ProductSet;

import java.util.List;

public interface ProductSetService {

    ProductSet save(ProductSet productSet);

    void removeProductSet(int id);

    List<ProductSet> findByCartId(int id) throws Exception;

    List<ProductSet> getProductSetsWithPrice (int cartId);
}
