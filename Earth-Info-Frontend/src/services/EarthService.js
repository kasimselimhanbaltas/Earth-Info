import axios from "axios";

const API_BASE_URL = 'http://localhost:8085'


class EarthService{
    getCountries() {
        return axios.get(API_BASE_URL + '/countries')
    }
    getCountryInfo(iso2) {
        return axios.get(API_BASE_URL + '/countries/' + iso2)
    }
    getStates(iso2) {
        return axios.get(API_BASE_URL + '/countries/' + iso2 + '/states')
    }
    getStateInfo(iso2, statename) {
        return axios.get(API_BASE_URL + '/countries/' + iso2 + '/states/' + statename)
    }
    getCities(iso2, statename) {
        return axios.get(API_BASE_URL + '/countries/' + iso2 + '/states/' + statename + '/cities') 
    }
    getCityInfo(iso2, statename, cityname) {
        return axios.get(API_BASE_URL + '/countries/' + iso2 + '/states/' + statename + '/cities/' + cityname)
    }

}

export default new EarthService