package sectors.task.sectorstaskbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sectors.task.sectorstaskbackend.dto.ClientUserDto;
import sectors.task.sectorstaskbackend.model.ClientUser;

@Mapper(componentModel = "spring")
public interface ClientUserMapper {
    @Mapping(target = "sectorUserId", source = "clientUser.sectorUserId")
    @Mapping(target = "firstName", source = "clientUser.firstName")
    @Mapping(target = "lastName", source = "clientUser.lastName")
    @Mapping(target = "email", source = "clientUser.email")
    @Mapping(target = "password", source = "clientUser.password")
    ClientUserDto clientUserToClientUserDTO(ClientUser clientUser);
}
