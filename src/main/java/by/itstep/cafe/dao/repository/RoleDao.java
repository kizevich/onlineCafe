package by.itstep.cafe.dao.repository;

import by.itstep.cafe.dao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoleDao extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String name);
}
