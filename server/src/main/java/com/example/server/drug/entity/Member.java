package com.example.server.drug.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Member")
public class Member {

    @Id
    @SequenceGenerator(name="Member_seq",sequenceName="Member_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Member_seq")
    @Column(name = "Member_ID")

    private @NonNull Long memid;
    private @NonNull String user;
    private @NonNull String pass;

}
