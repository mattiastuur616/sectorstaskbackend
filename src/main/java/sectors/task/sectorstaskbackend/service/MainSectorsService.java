package sectors.task.sectorstaskbackend.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sectors.task.sectorstaskbackend.dto.MainSectorDto;
import sectors.task.sectorstaskbackend.exception.SectorNotFoundException;
import sectors.task.sectorstaskbackend.mapper.MainSectorMapper;
import sectors.task.sectorstaskbackend.model.MainSector;
import sectors.task.sectorstaskbackend.repository.MainSectorsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MainSectorsService {
    private final MainSectorsRepository mainSectorsRepository;
    private final MainSectorMapper mainSectorsMapper;

    /**
     * Test string.
     *
     * @return list of main sector dto-s.
     */
    @Transactional
    public List<MainSectorDto> getAllMainSectors() {
        List<MainSectorDto> mainSectorsDtoList = new ArrayList<>();
        for (MainSector sector : mainSectorsRepository.findAll()) {
            mainSectorsDtoList.add(mainSectorsMapper.mainSectorToMainSectorDto(sector));
        }
        return mainSectorsDtoList;
    }

    @Transactional
    public MainSectorDto getMainSectorById(Long id) throws SectorNotFoundException {
        Optional<MainSector> existingSector = mainSectorsRepository.findById(id);
        if (existingSector.isPresent()) {
            return mainSectorsMapper.mainSectorToMainSectorDto(existingSector.get());
        }
        throw new SectorNotFoundException("Sector was not found");
    }

    @Transactional
    public String addMainSector(MainSector mainSector) {
        Optional<MainSector> existingMainSector = mainSectorsRepository.findBySectorId(mainSector.getSectorId());
        if (existingMainSector.isEmpty()) {
            mainSectorsRepository.save(mainSector);
            return "New main sector added";
        }
        return "New sector wasn't added";
    }
}
