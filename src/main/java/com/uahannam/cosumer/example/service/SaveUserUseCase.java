package com.uahannam.cosumer.example.service;

import com.uahannam.cosumer.example.dto.SaveUserKafkaDto;

public interface SaveUserUseCase {

    void saveUserData(SaveUserKafkaDto saveUserKafkaDto);
}
