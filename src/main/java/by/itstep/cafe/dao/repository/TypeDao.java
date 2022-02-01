package by.itstep.cafe.dao.repository;

import by.itstep.cafe.dao.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TypeDao extends JpaRepository<Type, Integer> {

    Optional<Type> findByName(String name);
}
