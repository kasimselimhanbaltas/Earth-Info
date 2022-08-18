package com.springbootinfoearth.service;

import com.springbootinfoearth.model.*;
import com.springbootinfoearth.dto.CityListDto;
import com.springbootinfoearth.dto.CountryListDto;
import com.springbootinfoearth.dto.StateListDto;
import com.springbootinfoearth.repository.CityRepository;
import com.springbootinfoearth.repository.CountryRepository;
import com.springbootinfoearth.repository.StateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EarthServiceImpl implements IEarthService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<CountryListDto> getAllCountries() {
        List<Country> country = countryRepository.findAllByOrderByNameAsc();
        List<CountryListDto> countryListDtos = new ArrayList<>();

        for (Country objectFromTable: country){
            CountryListDto countryListDto = modelMapper.map(objectFromTable, CountryListDto.class);
            countryListDtos.add(countryListDto);
        }
        return countryListDtos;

    }

    @Override
    public Country getCountry(String iso2) {

        return countryRepository.findByIso2(iso2);
    }

    @Override
    public List<StateListDto> getAllStatesOfCountry(String iso2) {
        List<State> allStates = stateRepository.findAllByCountryCodeOrderByNameAsc(iso2);
        List<StateListDto> stateListDtos = new ArrayList<>();

        for (State objectFromTable: allStates) {
            StateListDto stateListDto = modelMapper.map(objectFromTable, StateListDto.class);
            stateListDtos.add(stateListDto);
        }

        return stateListDtos;
    }

    @Override
    public State getState(String iso2, String statename) {
        return stateRepository.findByCountryCodeAndName(iso2, statename);
    }

    @Override
    public List<CityListDto> getAllCitiesOfState(String iso2, String statename) {
        List<City> cities = cityRepository.findAllByCountrycodeAndStatenameOrderByNameAsc(iso2, statename);
        List<CityListDto> citiesOfState = new ArrayList<>();

        for (City objectFromTable: cities){
            CityListDto cityListDto = modelMapper.map(objectFromTable, CityListDto.class);
            citiesOfState.add(cityListDto);
        }
        return citiesOfState;
    }

    @Override
    public City getCity(String iso2, String statename, String cityname) {

        return cityRepository.findByCountrycodeAndStatenameAndName(iso2, statename, cityname);
    }

}
