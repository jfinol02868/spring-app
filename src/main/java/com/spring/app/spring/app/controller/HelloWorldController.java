package com.spring.app.spring.app.controller;

import com.spring.app.spring.app.domain.entity.HelloWorldBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;


@RestController
@RequestMapping("/api")
public class HelloWorldController {


    private String message;

    private final MessageSource messageSource;
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

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

    @GetMapping("/hello")
    public String helloWorldHeader() {
        Locale locale = LocaleContextHolder.getLocale();
        LOG.info(".:: Esta es la ciudad del locale: {} y el código es: {} ", locale.getCountry(), locale.getDisplayName());
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale );
    }
}
