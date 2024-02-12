package sectors.task.sectorstaskbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientUserDto {

    private Long sectorUserId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public ClientUserDto(Long sectorUserId, String firstName, String lastName,
                         String email, String password) {
        this.sectorUserId = sectorUserId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
