package sectors.task.sectorstaskbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sectors.task.sectorstaskbackend.dto.UserSelectionDto;
import sectors.task.sectorstaskbackend.model.UserSelection;

@Mapper(componentModel = "spring")
public interface UserSelectionMapper {

    @Mapping(target = "selectionId", source = "userSelection.selectionId")
    @Mapping(target = "userName", source = "userSelection.userName")
    @Mapping(target = "selectedSector", source = "userSelection.selectedSector")
    @Mapping(target = "agreeToTerms", source = "userSelection.agreeToTerms")
    UserSelectionDto userSelectionToUserSelectionDto(UserSelection userSelection);
}
