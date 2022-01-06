package by.itstep.cafe.controller.impl;

import by.itstep.cafe.controller.ProductSetController;
import by.itstep.cafe.service.ProductSetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productSet")
public class ProductSetControllerImpl implements ProductSetController {

    private ProductSetService productSetService;

    public ProductSetControllerImpl(ProductSetService productSetService) {
        this.productSetService = productSetService;
    }


}
