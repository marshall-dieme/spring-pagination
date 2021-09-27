package org.spring.springpagination.service;

import java.util.ArrayList;
import java.util.List;

import org.spring.springpagination.model.Country;
import org.spring.springpagination.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    
    @Autowired
    CountryRepository countryRepository;

    public List<Country> getAll(int pageNo, int pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Country> pagedResult = countryRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        }
            return new ArrayList<Country>();
    }

    public Country getCountry(int id) {
        return countryRepository.findById(id).get();
    }
}