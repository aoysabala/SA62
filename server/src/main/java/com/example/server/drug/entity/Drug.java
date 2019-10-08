package com.example.server.drug.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Drug")
public class Drug {

    @Id
    @SequenceGenerator(name="Drug_seq",sequenceName="Drug_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Drug_seq")
    @Column(name = "Drug_ID")

    private @NonNull Long drugid;
    private @NonNull String drugsid;
    private @NonNull String named;
    private @NonNull String nameg;
    private @NonNull Double streangth;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = DrugType.class)
    @JoinColumn(name = "DrugType_ID")
    private DrugType drugtype;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = StrengthUnit.class)
    @JoinColumn(name = "StrengthUnit_ID")
    private StrengthUnit strengthunit;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = UnitOfMeasure.class)
    @JoinColumn(name = "UnitOfMeasure_ID")
    private UnitOfMeasure unitofmeasure;
}
