package sectors.task.sectorstaskbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sectors.task.sectorstaskbackend.model.UserSelection;

import java.util.Optional;

public interface UserSelectionRepository extends JpaRepository<UserSelection, Long> {
    Optional<UserSelection> findBySelectionId(Long id);
}
