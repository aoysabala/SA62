package com.example.server.pay.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="FinancialOfficer")
public class FinancialOfficer {

    @Id
    @SequenceGenerator(name="FinancialOfficer_seq",sequenceName="FinancialOfficer_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="FinancialOfficer_seq")
    @Column(name = "FinancialOfficer_ID", unique = true, nullable = true)

    private @NonNull Long finanId;
    private @NonNull String finanName;
}