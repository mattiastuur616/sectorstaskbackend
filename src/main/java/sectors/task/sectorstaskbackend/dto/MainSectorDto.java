package sectors.task.sectorstaskbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainSectorDto {

    private Long sectorId;
    private String sectorName;

    public MainSectorDto(Long sectorId, String sectorName) {
        this.sectorId = sectorId;
        this.sectorName = sectorName;
    }
}
