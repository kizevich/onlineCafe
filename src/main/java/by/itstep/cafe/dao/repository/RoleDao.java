package by.itstep.cafe.dao.repository;

import by.itstep.cafe.dao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleDao extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
