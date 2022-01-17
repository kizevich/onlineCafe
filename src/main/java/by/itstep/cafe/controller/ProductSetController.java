package by.itstep.cafe.controller;

import by.itstep.cafe.dao.entity.ProductSet;
import org.springframework.ui.Model;

public interface ProductSetController {

    String createProductSet(int id, Model model) throws Exception;
}
