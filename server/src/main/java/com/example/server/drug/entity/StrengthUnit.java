package com.example.server.drug.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="StrengthUnit")
public class StrengthUnit {

    @Id
    @SequenceGenerator(name="StrengthUnit_seq",sequenceName="StrengthUnit_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="StrengthUnit_seq")
    @Column(name = "StrengthUnit_ID")

    private @NonNull Long unitsid;
    private @NonNull String units;
}
