package com.springbootinfoearth.service;

import com.springbootinfoearth.model.*;
import com.springbootinfoearth.dto.CityListDto;
import com.springbootinfoearth.dto.CountryListDto;
import com.springbootinfoearth.dto.StateListDto;

import java.util.List;

public interface IEarthService {

    List<CountryListDto> getAllCountries();

    Country getCountry(String iso2);

    List<StateListDto> getAllStatesOfCountry(String iso2);

    State getState(String iso2, String statename);

    List<CityListDto> getAllCitiesOfState(String iso2, String statename);

    City getCity(String iso2, String statename, String cityname);

}
