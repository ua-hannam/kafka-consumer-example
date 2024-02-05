package com.uahannam.cosumer.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class BaseTimeEntity {

    @CreatedDate
    @Column(name = "READ_MODEL_REG_DATE")
    private LocalDateTime readModelRegDate;

    @LastModifiedDate
    @Column(name = "READ_MODEL_MOD_DATE")
    private LocalDateTime readModelModDate;
}
