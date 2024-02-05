package com.uahannam.cosumer.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.domain.Persistable;

import java.time.LocalDateTime;

@Entity
@Getter @Builder
@AllArgsConstructor
@Table(name = "USERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity
        implements Persistable<Long> {

    @Id
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Column(name = "USER_NICKNAME")
    private String userNickName;

    @Column(name = "USER_REG_DATE")
    private LocalDateTime userRegDate;

    @Column(name = "USER_MOD_DATE")
    private LocalDateTime userModDate;

    @Override
    public boolean isNew() {
        return getReadModelRegDate() == null;
    }
}
