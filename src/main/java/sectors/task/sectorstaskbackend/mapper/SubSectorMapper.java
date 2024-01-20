package sectors.task.sectorstaskbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sectors.task.sectorstaskbackend.dto.SubSectorDto;
import sectors.task.sectorstaskbackend.model.SubSector;

@Mapper(componentModel = "spring")
public interface SubSectorMapper {

    @Mapping(target = "pairId", source = "subSector.pairId")
    @Mapping(target = "motherSector", source = "subSector.motherSector")
    @Mapping(target = "subSector", source = "subSector.subSector")
    SubSectorDto subSectorToSubSectorDto(SubSector subSector);
}
