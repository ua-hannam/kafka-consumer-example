package com.uahannam.cosumer.example.kafka;

import com.uahannam.cosumer.example.dto.SaveUserKafkaDto;
import com.uahannam.cosumer.example.service.SaveUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveUserDataListener {

    private final SaveUserUseCase saveUserUseCase;

    @KafkaListener(topics = "save-user-data", groupId = "save-user-data", containerFactory = "saveUserDataKafkaListenerContainerFactory")
    void consumeUserData(@Payload SaveUserKafkaDto userKafkaDto) {
        System.out.println("KAKFA 요청 도착 =======================================");
        System.out.println("userKafkaDto : " + userKafkaDto);
        saveUserUseCase.saveUserData(userKafkaDto);

        System.out.println("KAFKA 요청 처리 완료 ===================================");
        System.out.println();
    }
}
