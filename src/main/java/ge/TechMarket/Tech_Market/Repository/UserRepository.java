package ge.TechMarket.Tech_Market.Repository;

import ge.TechMarket.Tech_Market.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<user, Long> {
    Optional<user> findByEmail(String email);
}
