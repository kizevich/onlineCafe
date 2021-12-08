package by.itstep.cafe.dao.repository;

import by.itstep.cafe.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {

    Optional<User> findUserByUserName(String name);

}
