package sectors.task.sectorstaskbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sectors.task.sectorstaskbackend.model.MainSector;

import java.util.Optional;

public interface MainSectorsRepository extends JpaRepository<MainSector, Long> {
    Optional<MainSector> findBySectorId(Long id);
}
