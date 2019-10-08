package com.example.server.pay.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="TreatmentRights")
public class TreatmentRights {

    @Id
    @SequenceGenerator(name="TreatmentRights_seq",sequenceName="TreatmentRights_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TreatmentRights_seq")
    @Column(name = "TreatmentRights_ID", unique = true, nullable = true)

    private @NonNull Long treatmentId;
    private @NonNull String treatment;
}
