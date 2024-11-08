package com.spring.app.spring.app.controller;

import com.spring.app.spring.app.domain.entity.User;
import com.spring.app.spring.app.domain.exception.UserNotFoundException;
import com.spring.app.spring.app.repository.impl.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll(){
        return new ResponseEntity<>(userDaoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userDaoService.findOne(id);
        if(Objects.isNull(user))
            throw new UserNotFoundException("Usuario con ID: " +id+ " no existe.", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User userSaved = userDaoService.save(user);
        //Esta respuesta la devuelve en el header
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userSaved.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Integer id) {
        User user = userDaoService.findOne(id);
        if(Objects.isNull(user))
            throw new UserNotFoundException("Usuario con ID: " +id+ " no existe.", HttpStatus.NOT_FOUND);
        userDaoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
