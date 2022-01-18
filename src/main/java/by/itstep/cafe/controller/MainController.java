package by.itstep.cafe.controller;

import by.itstep.cafe.dao.entity.Cart;
import org.springframework.ui.Model;

public interface MainController {

    public String index();

    public String showMenu(Cart cart, Model model);

    String createProductSet(Cart cart, int count, Model model) throws Exception;

}
