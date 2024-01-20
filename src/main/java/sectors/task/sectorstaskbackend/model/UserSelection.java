package sectors.task.sectorstaskbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_selection")
public class UserSelection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "selection_id")
    private Long selectionId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "selected_sector")
    private String selectedSector;

    @Column(name = "agree_to_terms")
    private Boolean agreeToTerms;
}
