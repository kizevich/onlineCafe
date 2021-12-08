package by.itstep.cafe.controller.impl;

import by.itstep.cafe.controller.TypeController;
import by.itstep.cafe.dao.entity.Type;
import by.itstep.cafe.service.TypeService;

import java.util.List;

public class TypeControllerImpl implements TypeController {

    private TypeService typeService;

    public TypeControllerImpl(TypeService typeService) {
        this.typeService = typeService;
    }

    @Override
    public Type addType(Type type) {
        return typeService.addType(type);
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
