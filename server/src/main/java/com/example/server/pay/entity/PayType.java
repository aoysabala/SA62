package com.example.server.pay.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="PayType")
public class PayType {

    @Id
    @SequenceGenerator(name="PayType_seq",sequenceName="PayType_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PayType_seq")
    @Column(name = "PayType_ID", unique = true, nullable = true)

    private @NonNull Long paytypeId;
    private @NonNull String paytype;
}
