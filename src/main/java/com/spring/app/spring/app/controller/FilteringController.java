package com.spring.app.spring.app.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.spring.app.spring.app.domain.entity.filter.SomeBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FilteringController {

    @GetMapping("/v1/filtering")
    public ResponseEntity<Object> staticFilter() {
        SomeBean bean = new SomeBean("field1","field2", "field3");
        return new ResponseEntity<>(this.applyFilter("SomeBeanFilter", List.of(bean), "field2", "field3"), HttpStatus.OK);
    }
    @GetMapping("/v1/filtering-list")
    public ResponseEntity<MappingJacksonValue> staticFilterList() {
        List<SomeBean> beans = Arrays.asList(
                new SomeBean("field1","field2", "field3"),
                new SomeBean("field4","field5", "field6"),
                new SomeBean("field7","field8", "field9")
        );
        return new ResponseEntity<>(this.applyFilter("SomeBeanFilter", beans, "field1", "field3"), HttpStatus.OK);
    }

    private MappingJacksonValue applyFilter(String id, List<SomeBean> bean, String... values) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(bean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(values);
        FilterProvider filters = new SimpleFilterProvider().addFilter(id, filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}
