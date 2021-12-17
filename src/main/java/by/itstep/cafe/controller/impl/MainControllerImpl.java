package by.itstep.cafe.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainControllerImpl {

    @RequestMapping({"/", ""})
    public String index(Model model) {
        return "mainPage/mainPage";
    }

}
