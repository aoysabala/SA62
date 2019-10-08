package com.example.server.drug.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="UnitOfMeasure")
public class UnitOfMeasure {

    @Id
    @SequenceGenerator(name="UnitOfMeasure_seq",sequenceName="UnitOfMeasure_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="UnitOfMeasure_seq")
    @Column(name = "UnitOfMeasure_ID")

    private @NonNull Long unitmid;
    private @NonNull String unitm;
}
