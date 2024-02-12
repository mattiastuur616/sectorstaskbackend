package sectors.task.sectorstaskbackend.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sectors.task.sectorstaskbackend.dto.MainSectorDto;
import sectors.task.sectorstaskbackend.dto.SubSectorDto;
import sectors.task.sectorstaskbackend.exception.SectorNotFoundException;
import sectors.task.sectorstaskbackend.mapper.SubSectorMapper;
import sectors.task.sectorstaskbackend.model.SubSector;
import sectors.task.sectorstaskbackend.repository.SubSectorsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubSectorsService {
    private final SubSectorsRepository subSectorsRepository;
    private final SubSectorMapper subSectorMapper;

    @Transactional
    public List<SubSectorDto> getAllSubSectors() {
        List<SubSectorDto> subSectorDtoList = new ArrayList<>();
        for (SubSector subSector : subSectorsRepository.findAll()) {
            subSectorDtoList.add(subSectorMapper.subSectorToSubSectorDto(subSector));
        }
        return subSectorDtoList;
    }

    @Transactional
    public SubSectorDto getSubSectorById(Long id) throws SectorNotFoundException {
        Optional<SubSector> existingSubSector = subSectorsRepository.findById(id);
        if (existingSubSector.isPresent()) {
            return subSectorMapper.subSectorToSubSectorDto(existingSubSector.get());
        }
        throw new SectorNotFoundException("Sector was not found");
    }

    @Transactional
    public List<MainSectorDto> getSubSectorsById(String sectorName) {
        List<MainSectorDto> subSectorDtoList = new ArrayList<>();
        for (SubSector subSector : subSectorsRepository.findByMotherSector(sectorName)) {
            subSectorDtoList.add(new MainSectorDto(subSector.getPairId(), subSector.getSubSector()));
        }
        return subSectorDtoList;
    }

    @Transactional
    public String addNewSubSector(SubSector subSector) {
        Optional<SubSector> existingSubSector = subSectorsRepository.findByPairId(subSector.getPairId());
        if (existingSubSector.isEmpty()) {
            subSectorsRepository.save(subSector);
            return "Added new sub sector";
        }
        return "New sector wasn't added";
    }
}
