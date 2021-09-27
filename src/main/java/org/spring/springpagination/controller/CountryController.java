package org.spring.springpagination.controller;

import java.util.List;


import org.spring.springpagination.model.Country;
import org.spring.springpagination.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/countries")
public class CountryController {
    
    @Autowired
    CountryService countryService;

    @GetMapping(value="")
    public ResponseEntity<List<Country>> getCountries(@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {
        
        List<Country> countries = countryService.getAll(pageNo, pageSize, sortBy);

        return new ResponseEntity<>(countries, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity<Country> getCountry(@PathVariable int id) {
        return new ResponseEntity<>(countryService.getCountry(id), new HttpHeaders(), HttpStatus.OK);
    }
    
}