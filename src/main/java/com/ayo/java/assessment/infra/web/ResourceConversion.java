package com.ayo.java.assessment.infra.web;

import com.ayo.java.assessment.service.convertor.ConvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/convert")
public class ResourceConversion {

    private final ConvService convService;

    @Autowired
    public ResourceConversion(final ConvService convService) {
        this.convService = convService;
    }

    @RequestMapping(value = "/{measurement}/{toSystem}/{value}",
            method = RequestMethod.GET,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public ResponseEntity<String> convert(@PathVariable final String measurement, @PathVariable final String toSystem, @PathVariable final Double value) {
        return convService.convert(measurement, toSystem, value);
    }

    @RequestMapping(value = "/measurements",
            method = RequestMethod.GET,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public ResponseEntity<List<String>> getMeasurements() {
        return convService.getMeasurements();
    }

    @RequestMapping(value = "/si-units",
            method = RequestMethod.GET,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public ResponseEntity<List<String>> getSiUnits() {
        return convService.getSiUnits();
    }
}
