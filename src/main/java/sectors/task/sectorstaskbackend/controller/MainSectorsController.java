package sectors.task.sectorstaskbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sectors.task.sectorstaskbackend.dto.MainSectorDto;
import sectors.task.sectorstaskbackend.exception.SectorNotFoundException;
import sectors.task.sectorstaskbackend.model.MainSector;
import sectors.task.sectorstaskbackend.service.MainSectorsService;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
@RestController
@RequiredArgsConstructor
public class MainSectorsController {
    private final MainSectorsService mainSectorsService;

    @GetMapping("/allMainSectors")
    public List<MainSectorDto> getAllMainSectors() {
        return mainSectorsService.getAllMainSectors();
    }

    @GetMapping("/getSector/{id}")
    public MainSectorDto getMainSectorById(@PathVariable Long id) throws SectorNotFoundException {
        return mainSectorsService.getMainSectorById(id);
    }

    @PostMapping("/addSector")
    public String addNewMainSector(@RequestBody MainSector mainSector) {
        return mainSectorsService.addMainSector(mainSector);
    }
}
