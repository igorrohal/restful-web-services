package com.irohal.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBeanForFiltering filtering() {
        return new SomeBeanForFiltering("value1", "value2", "value3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBeanForFiltering> filteringList() {
        return Arrays.asList(
                new SomeBeanForFiltering("1.1", "1.2", "1.3"),
                new SomeBeanForFiltering("1.1", "1.2", "1.3"));
    }

}
