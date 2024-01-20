package sectors.task.sectorstaskbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSelectionDto {

    private Long selectionId;
    private String userName;
    private String selectedSector;
    private Boolean agreeToTerms;

    public UserSelectionDto(Long selectionId, String userName, String selectedSector, Boolean agreeToTerms) {
        this.selectionId = selectionId;
        this.userName = userName;
        this.selectedSector = selectedSector;
        this.agreeToTerms = agreeToTerms;
    }
}
