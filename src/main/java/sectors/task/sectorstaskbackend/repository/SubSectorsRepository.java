package sectors.task.sectorstaskbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sectors.task.sectorstaskbackend.model.SubSector;

import java.util.List;
import java.util.Optional;

public interface SubSectorsRepository extends JpaRepository<SubSector, Long> {
    Optional<SubSector> findByPairId(Long id);

    List<SubSector> findByMotherSector(String motherSector);
}
