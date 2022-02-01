package by.itstep.cafe.dao.repository;

import by.itstep.cafe.dao.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface StatusDao extends JpaRepository<Status, Integer> {

    Optional<Status> findByName(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM status WHERE status.discount > :discount ORDER BY status.discount LIMIT 1")
    Optional<Status> findNextStatus(int discount);

    int getDiscountById(int id);

}
