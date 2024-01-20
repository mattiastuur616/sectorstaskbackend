package sectors.task.sectorstaskbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sectors.task.sectorstaskbackend.dto.MainSectorDto;
import sectors.task.sectorstaskbackend.model.MainSector;

@Mapper(componentModel = "spring")
public interface MainSectorMapper {

    @Mapping(target = "sectorId", source = "mainSector.sectorId")
    @Mapping(target = "sectorName", source = "mainSector.sectorName")
    MainSectorDto mainSectorToMainSectorDto(MainSector mainSector);
}
