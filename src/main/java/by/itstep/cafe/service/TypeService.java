package by.itstep.cafe.service;

import by.itstep.cafe.dao.entity.Type;

import java.util.List;

public interface TypeService {

    Type addType(Type type);

    void removeType(int id);

    List listTypes();

    Type getType(String name);
}
