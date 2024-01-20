package sectors.task.sectorstaskbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sub_sectors")
public class SubSector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pair_id")
    private Long pairId;

    @Column(name = "mother_sector")
    private String motherSector;

    @Column(name = "sub_sector")
    private String subSector;
}
