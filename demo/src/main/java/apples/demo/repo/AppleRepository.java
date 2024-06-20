package apples.demo.repo;

import apples.demo.entity.Apple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppleRepository extends JpaRepository<Apple, Long> {
}
