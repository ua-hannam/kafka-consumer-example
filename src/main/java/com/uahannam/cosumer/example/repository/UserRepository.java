package com.uahannam.cosumer.example.repository;

import com.uahannam.cosumer.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
