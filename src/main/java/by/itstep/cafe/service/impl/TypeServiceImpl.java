package by.itstep.cafe.service.impl;

import by.itstep.cafe.dao.repository.TypeDao;
import by.itstep.cafe.dao.entity.Type;
import by.itstep.cafe.service.TypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    private TypeDao typeDao;

    public TypeServiceImpl(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    @Override
    public Type save(Type type) {
       return typeDao.save(type);
    }

    @Override
    public void removeType(int id) {
        typeDao.deleteById(id);;
    }

    @Override
    public List listTypes() {
        return typeDao.findAll();
    }

    @Override
    public Type getType(String name) {
        return typeDao.findByName(name);
    }

    @Override
    public Type findById(int id) {

        return typeDao.findById(id).get();
    }
}
