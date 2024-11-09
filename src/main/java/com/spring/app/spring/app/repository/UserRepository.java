package com.spring.app.spring.app.repository;

import com.spring.app.spring.app.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
