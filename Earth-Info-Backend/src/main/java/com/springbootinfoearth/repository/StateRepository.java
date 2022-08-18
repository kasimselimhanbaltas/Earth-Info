
package com.springbootinfoearth.repository;

import com.springbootinfoearth.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

    List<State> findAllByCountryCodeOrderByNameAsc(String iso2);

    State findByCountryCodeAndName(String iso2, String statename);
}
