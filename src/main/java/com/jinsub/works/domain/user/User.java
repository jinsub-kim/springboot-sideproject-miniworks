package com.jinsub.works.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private Long domainId;

    @Column(nullable = false)
    private String account;

    @Column(length = 100, nullable = false)
    private String userName;

    @Column(length = 200, nullable = false)
    private String userExternalKey;

    @Column
    private String cellPhone;

    @Column
    private String email;

    @Column
    private LocalDateTime hireDate;

    @Builder
    public User(Long domainId, String account, String userName, String userExternalKey,
                String cellPhone, String email, LocalDateTime hireDate) {
        this.domainId = domainId;
        this.account = account;
        this.userName = userName;
        this.userExternalKey = userExternalKey;
        this.cellPhone = cellPhone;
        this.email = email;
        this.hireDate = hireDate;
    }
}
