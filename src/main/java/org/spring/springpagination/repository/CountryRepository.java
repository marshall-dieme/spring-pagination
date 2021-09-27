package org.spring.springpagination.repository;

import org.springframework.stereotype.Repository;
import org.spring.springpagination.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Integer> {
    
}