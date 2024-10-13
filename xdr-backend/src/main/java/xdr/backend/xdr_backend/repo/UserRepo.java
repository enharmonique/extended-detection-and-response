package xdr.backend.xdr_backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import xdr.backend.xdr_backend.model.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
