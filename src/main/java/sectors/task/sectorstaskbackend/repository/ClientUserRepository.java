package sectors.task.sectorstaskbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sectors.task.sectorstaskbackend.model.ClientUser;

import java.util.Optional;

public interface ClientUserRepository extends JpaRepository<ClientUser, Long> {
    Optional<ClientUser> findClientUserBySectorUserId(Long id);
    Optional<ClientUser> findClientUserByEmail(String email);
}
