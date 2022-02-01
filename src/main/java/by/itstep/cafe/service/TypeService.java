package by.itstep.cafe.service;

import by.itstep.cafe.dao.entity.Type;

import java.util.List;

public interface TypeService {

    Type save(Type type);

    void removeType(int id);

    List<Type> listTypes();

    Type getTypeByName(String name) throws Exception;

    Type findById(int id) throws Exception;
}
