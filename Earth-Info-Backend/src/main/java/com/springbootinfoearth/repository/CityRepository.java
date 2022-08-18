package com.springbootinfoearth.repository;

import com.springbootinfoearth.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    List<City> findAllByCountrycodeAndStatenameOrderByNameAsc(String iso2, String statename);

    City findByCountrycodeAndStatenameAndName(String iso2, String statename, String cityname);

}

