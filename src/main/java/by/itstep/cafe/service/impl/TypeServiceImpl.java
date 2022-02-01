package by.itstep.cafe.service.impl;

import by.itstep.cafe.dao.repository.TypeDao;
import by.itstep.cafe.dao.entity.Type;
import by.itstep.cafe.service.TypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {

    private final TypeDao typeDao;

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
    public List<Type> listTypes() {
        return typeDao.findAll();
    }

    @Override
    public Type getTypeByName(String name) throws Exception {
        Optional<Type> optionalType = typeDao.findByName(name);

        if (optionalType.isPresent()){
            Type type = optionalType.get();

            return type;
        } else {
            throw new Exception("type is not exist");
        }
    }

    @Override
    public Type findById(int id) throws Exception {
        Optional<Type> optionalType = typeDao.findById(id);

        if (optionalType.isPresent()){
            Type type = optionalType.get();

            return type;
        } else {
            throw new Exception("type is not exist");
        }
    }
}
