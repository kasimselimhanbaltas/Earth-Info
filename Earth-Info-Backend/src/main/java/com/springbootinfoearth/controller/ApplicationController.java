package com.springbootinfoearth.controller;

import com.springbootinfoearth.model.*;
import com.springbootinfoearth.dto.CityListDto;
import com.springbootinfoearth.dto.CountryListDto;
import com.springbootinfoearth.dto.StateListDto;
import com.springbootinfoearth.service.EarthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080/")
public class ApplicationController implements CommandLineRunner {

    @Autowired
    private EarthServiceImpl earthServiceImpl;

    @RequestMapping
    public List<String> welcome() {
        List<String> ret = new ArrayList<>();
        ret.add("WELCOME! Example url mapping:");
        ret.add("http://localhost:8085/countries/");
        ret.add("http://localhost:8085/countries/TR ");
        ret.add("http://localhost:8085/countries/TR/states");
        ret.add("http://localhost:8085/countries/TR/states/Istanbul");
        ret.add("http://localhost:8085/countries/TR/states/Istanbul/cities");
        ret.add("http://localhost:8085/countries/TR/states/Istanbul/cities/Kadıköy");
        return ret;
    }

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public List<CountryListDto> handler1() {
        return earthServiceImpl.getAllCountries();
    }

    @RequestMapping(value = "/countries/{iso2}", method = RequestMethod.GET)
    public @ResponseBody
    Country handler2(@PathVariable String iso2) {
        return earthServiceImpl.getCountry(iso2);
    }

    @RequestMapping(value = "/countries/{iso2}/states", method = RequestMethod.GET)
    public @ResponseBody
    List<StateListDto> handler3(@PathVariable String iso2) {
        return earthServiceImpl.getAllStatesOfCountry(iso2);
    }

    @RequestMapping(value = "/countries/{iso2}/states/{statename}", method = RequestMethod.GET)
    public @ResponseBody
    State handler4(@PathVariable String iso2, @PathVariable String statename) {
        return earthServiceImpl.getState(iso2, statename);
    }

    @RequestMapping(value = "/countries/{iso2}/states/{statename}/cities", method = RequestMethod.GET)
    public @ResponseBody
    List<CityListDto> handler5(@PathVariable String iso2, @PathVariable String statename) {
        return earthServiceImpl.getAllCitiesOfState(iso2, statename);
    }

    @RequestMapping(value = "/countries/{iso2}/states/{statename}/cities/{cityname}", method = RequestMethod.GET)
    public @ResponseBody
    City handler6(@PathVariable String iso2, @PathVariable String statename, @PathVariable String cityname) {
        return earthServiceImpl.getCity(iso2, statename, cityname);
    }

    @Override // ?
    public void run(String... args) {

    }
}
