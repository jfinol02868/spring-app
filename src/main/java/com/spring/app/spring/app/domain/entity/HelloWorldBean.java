package com.spring.app.spring.app.domain.entity;

public class HelloWorldBean {

    private String value;

    public HelloWorldBean(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
