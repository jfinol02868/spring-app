package com.spring.app.spring.app.controller;

import com.spring.app.spring.app.domain.entity.version.Name;
import com.spring.app.spring.app.domain.entity.version.PersonV1;
import com.spring.app.spring.app.domain.entity.version.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonController {

    @GetMapping("/v1/persons")
    public PersonV1 getPersonV1() {
        return new PersonV1("Jesus Finol");
    }

    @GetMapping("/v2/persons")
    public PersonV2 getPersonV2() {
        return new PersonV2(new Name("Jesus", "Finol"));
    }

    @GetMapping(path = "/v1/persons", params = "version=1")
    public PersonV1 getPersonParamV1() {
        return new PersonV1("Jesus Finol");
    }

    @GetMapping(path = "/v2/persons", params = "version=2")
    public PersonV2 getPersonParamV2() {
        return new PersonV2(new Name("Jesus", "Finol"));
    }

    @GetMapping(path = "/v1/persons/header", headers = {"X-API-VERSION=1"})
    public PersonV1 getPersonHeaderV1() {
        return new PersonV1("Jesus Finol");
    }

    @GetMapping(path = "/v2/persons/header",
            headers = {"X-API-VERSION=2", "APP=spring", "TYPE=Java"})
    public PersonV2 getPersonHeaderV2() {
        return new PersonV2(new Name("Jesus", "Finol"));
    }

    @GetMapping(path = "/v1/persons/accept", produces = {"application/vnd.company.app-v1+json"})
    public PersonV1 getPersonAcceptV1() {
        return new PersonV1("Jesus Finol");
    }

    @GetMapping(path = "/v2/persons/accept",
            produces = {"application/vnd.company.app-v2+json"})
    public PersonV2 getPersonAcceptV2() {
        return new PersonV2(new Name("Jesus", "Finol"));
    }
}
