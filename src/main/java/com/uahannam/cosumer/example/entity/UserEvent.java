package com.uahannam.cosumer.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Builder
@AllArgsConstructor
@Table(name = "USER_EVENT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEvent extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_EVENT_ID")
    private Long userEventId;

    @Column(name = "USER_EVENT_UUID")
    private String eventUUID;

    @Column(name = "USER_ID")
    private Long userId;

}
