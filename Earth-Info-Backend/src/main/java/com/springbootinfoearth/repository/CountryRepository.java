package com.springbootinfoearth.repository;

import com.springbootinfoearth.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    Country findByIso2(String iso2);

    List<Country> findAllByOrderByNameAsc();

}

