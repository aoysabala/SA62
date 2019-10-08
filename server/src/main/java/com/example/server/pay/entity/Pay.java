package com.example.server.pay.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Pay")
public class Pay {

    @Id
    @SequenceGenerator(name="Pay_seq",sequenceName="Pay_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Pay_seq")
    @Column(name = "Pay_ID", unique = true, nullable = true)

    private @NonNull Long payId;
    private @NonNull Date paydate;
    private @NonNull String namepay;
    private @NonNull Double totleprice;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = FinancialOfficer.class)
    @JoinColumn(name = "FinancialOfficer_ID", insertable = true)
    private FinancialOfficer financialOfficer;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PayType.class)
    @JoinColumn(name = "PayType_ID", insertable = true)
    private PayType Paytype;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TreatmentRights.class)
    @JoinColumn(name = "TreatmentRights_ID", insertable = true)
    private TreatmentRights treatmentrights;
}
