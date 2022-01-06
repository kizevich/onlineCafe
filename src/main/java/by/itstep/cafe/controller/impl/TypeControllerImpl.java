package by.itstep.cafe.controller.impl;

import by.itstep.cafe.controller.TypeController;
import by.itstep.cafe.dao.entity.Role;
import by.itstep.cafe.dao.entity.Type;
import by.itstep.cafe.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/type")
public class TypeControllerImpl implements TypeController {

    private TypeService typeService;

    public TypeControllerImpl(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("types", typeService.listTypes());

        return "type/index";
    }

    @GetMapping("/new")
    public String newType(Model model) {
        model.addAttribute("type", new Type());

        return "type/new";
    }

    @PostMapping()
    public String create(Type type, Model model) throws Exception {
        typeService.save(type);

        return "redirect:/type";
    }

    @GetMapping("delete/{id}")
    public String deleteType(@PathVariable("id") int id) {
        typeService.removeType(id);

        return "redirect:/type";
    }

    @GetMapping("edit/{id}")
    public String updateTypeForm(@PathVariable("id") int id, Model model) {
        Type type = typeService.findById(id);
        model.addAttribute("type", type);

        return "type/edit";
    }

    @PostMapping("/edit")
    public String updateType(Type type) throws Exception {
        typeService.save(type);

        return "redirect:/type";
    }

    @Override
    public Type addType(Type type) {
        return typeService.save(type);
    }

    @Override
    public void removeType(int id) {
        typeService.removeType(id);
    }

    @Override
    public List listTypes() {
        return typeService.listTypes();
    }

    @Override
    public Type getType(String name) {
        return typeService.getType(name);
    }
}
