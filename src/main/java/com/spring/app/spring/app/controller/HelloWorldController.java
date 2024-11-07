package com.spring.app.spring.app.controller;

import com.spring.app.spring.app.domain.entity.HelloWorldBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class HelloWorldController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);

    @GetMapping("/hello/{name}")
    public ResponseEntity<Object> helloWorld(@PathVariable(name = "name", required = false) String name) {
        LOG.info(".:: Este es un log de tipo info ::.");
        return new ResponseEntity<>("Hello world... ".concat(name), HttpStatus.OK);
    }

    @GetMapping("/hello-bean")
    public ResponseEntity<HelloWorldBean> helloWorldBean(@RequestParam(name = "name") String name) {
        LOG.info(".:: Este es un log de tipo info bean ::.");
        return new ResponseEntity<>(new HelloWorldBean("Hello world... ".concat(name)), HttpStatus.OK);
    }
}
