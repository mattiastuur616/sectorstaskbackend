package sectors.task.sectorstaskbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sectors.task.sectorstaskbackend.dto.SubSectorDto;
import sectors.task.sectorstaskbackend.exception.SectorNotFoundException;
import sectors.task.sectorstaskbackend.model.SubSector;
import sectors.task.sectorstaskbackend.service.SubSectorsService;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
@RestController
@RequiredArgsConstructor
public class SubSectorsController {
    private final SubSectorsService subSectorsService;

    @GetMapping("/allSubSectors")
    public List<SubSectorDto> getAllSubSectors() {
        return subSectorsService.getAllSubSectors();
    }

    @GetMapping("/subSector/{id}")
    public SubSectorDto getSubSectorById(@PathVariable Long id) throws SectorNotFoundException {
        return subSectorsService.getSubSectorById(id);
    }

    @PostMapping("/addSubSector")
    public String addNewSubSector(@RequestBody SubSector subSector) {
        return subSectorsService.addNewSubSector(subSector);
    }
}
