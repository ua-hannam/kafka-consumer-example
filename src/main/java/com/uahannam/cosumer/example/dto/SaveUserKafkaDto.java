package com.uahannam.cosumer.example.dto;

import com.uahannam.cosumer.example.entity.User;
import com.uahannam.cosumer.example.entity.UserEvent;

public record SaveUserKafkaDto(
        UserInfo userInfo,
        UserEventDto userEvent
) {



    public User mapToUserEntity() {
        return User.builder()
                .id(userInfo().userId())
                .userEmail(userInfo.userEmail())
                .userNickName(userInfo.userNickName())
                .userRegDate(userInfo.regDate())
                .userModDate(userInfo.modDate())
                .build();
    }

    public UserEvent mapToUserEventEntity() {
        return UserEvent.builder()
                .userId(userEvent.userId())
                .eventUUID(userEvent.eventUUID())
                .build();
    }
}

