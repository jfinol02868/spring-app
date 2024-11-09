package com.spring.app.spring.app.repository.impl;

import com.spring.app.spring.app.domain.entity.User;
import com.spring.app.spring.app.domain.exception.UserNotFoundException;
import com.spring.app.spring.app.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private final UserRepository userRepository;
    private static final Logger LOG = LoggerFactory.getLogger(UserDaoService.class);

    public UserDaoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User findOne(Integer id) {
        return userRepository.findById(id).orElseThrow(() ->new UserNotFoundException("El usuario que esta buscando no existe."));
    }

    public void deleteById(Integer id) {
        userRepository.findById(id);
    }
}
