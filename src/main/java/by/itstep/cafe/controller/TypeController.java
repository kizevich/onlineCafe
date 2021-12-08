package by.itstep.cafe.controller;

import by.itstep.cafe.dao.entity.Type;

import java.util.List;

public interface TypeController {

    Type addType(Type type);

    void removeType(int id);

    List listTypes();

    Type getType(String name);
}
