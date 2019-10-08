package com.example.server.drug.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="DrugType")
public class DrugType {

    @Id
    @SequenceGenerator(name="DrugType_seq",sequenceName="DrugType_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DrugType_seq")
    @Column(name = "DrugType_ID")

    private @NonNull Long typeid;
    private @NonNull String drugt;

}
