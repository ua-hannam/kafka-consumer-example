package com.uahannam.cosumer.example.service;

import com.uahannam.cosumer.example.dto.SaveUserKafkaDto;
import com.uahannam.cosumer.example.entity.UserEvent;
import com.uahannam.cosumer.example.repository.UserEventRepository;
import com.uahannam.cosumer.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SaveUserService implements SaveUserUseCase {

    private final UserRepository userRepository;
    private final UserEventRepository userEventRepository;

    @Override
    public void saveUserData(SaveUserKafkaDto saveUserKafkaDto) {
        Optional<UserEvent> findEvent = userEventRepository.findByEventUUID(saveUserKafkaDto.userEvent().eventUUID());

        if (findEvent.isEmpty()) {
            userRepository.save(saveUserKafkaDto.mapToUserEntity());
            userEventRepository.save(saveUserKafkaDto.mapToUserEventEntity());
        }
    }
}
