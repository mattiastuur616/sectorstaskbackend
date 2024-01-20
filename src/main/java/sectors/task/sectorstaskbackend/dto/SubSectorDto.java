package sectors.task.sectorstaskbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubSectorDto {

    private Long pairId;
    private String motherSector;
    private String subSector;

    public SubSectorDto(Long pairId, String motherSector, String subSector) {
        this.pairId = pairId;
        this.motherSector = motherSector;
        this.subSector = subSector;
    }
}
