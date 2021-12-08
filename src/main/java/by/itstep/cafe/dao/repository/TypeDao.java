package by.itstep.cafe.dao.repository;

import by.itstep.cafe.dao.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TypeDao extends JpaRepository<Type, Integer> {

    Type findByName(String name);
}
