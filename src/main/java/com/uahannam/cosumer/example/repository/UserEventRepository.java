package com.uahannam.cosumer.example.repository;

import com.uahannam.cosumer.example.entity.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserEventRepository extends JpaRepository<UserEvent, Long> {

    Optional<UserEvent> findByEventUUID(String eventUUID);
}
