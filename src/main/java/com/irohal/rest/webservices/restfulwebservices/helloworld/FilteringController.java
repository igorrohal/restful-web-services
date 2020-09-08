package com.irohal.rest.webservices.restfulwebservices.helloworld;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering") // dynamic filtering: only 'field1' and 'field2' returned
    public MappingJacksonValue filtering() {
        final SomeBeanForFiltering someBean = new SomeBeanForFiltering("value1", "value2", "value3");

        final SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        final FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        final MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/filtering-list") // dynamic filtering: only 'field3' returned
    public MappingJacksonValue filteringList() {
        final List<SomeBeanForFiltering> someBeans = Arrays.asList(
                new SomeBeanForFiltering("1.1", "1.2", "1.3"),
                new SomeBeanForFiltering("1.1", "1.2", "1.3"));

        final SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field3");
        final FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        final MappingJacksonValue mapping = new MappingJacksonValue(someBeans);
        mapping.setFilters(filters);

        return mapping;
    }

}
