import { createStore } from 'vuex'
import EarthService from '@/services/EarthService'

export default createStore({
    state: { //data
    selectedCountryCode: '',
    selectedStateName: '',

    detailObject: {
      name: ''
    },
    fetchedList: null,

  },
  getters: {
    getselectedCountryCode(state) {
      return state.selectedCountryCode
    },
    getselectedStateName(state) {
      return state.selectedStateName
    },
    getdetailObject(state) {
      return state.detailObject
    },
    getfetchedList(state) {
      return state.fetchedList
    },
    
  },
  
  mutations: {
    setselectedCountryCode(state, countrycode) {  
      state.selectedCountryCode = countrycode
    },
    setselectedStateName(state, statename) {
      state.selectedStateName = statename
    },
    setDetailObject(state, detailObject) {
      state.detailObject = detailObject
    },
    setFetchedList(state, fetchedList) {
      state.fetchedList = fetchedList
    },

  },
  actions: {
    async fetchCountryList(context){
      await EarthService.getCountries().
      then(response => {
        context.commit('setFetchedList', response.data)
       })
    },
    async fetchCountryDetail(context, countrycode){
      await EarthService.getCountryInfo(countrycode).
      then(response => {
        response.data.timezones = eval(response.data.timezones)
        context.commit('setDetailObject', response.data)
       })
    },
    async fetchStateList(context, countrycode){
      await EarthService.getStates(countrycode).
      then(response => {
        context.commit('setFetchedList', response.data)
       })
    },
    async fetchStateDetail(context, {countrycode, statename}){
      await EarthService.getStateInfo(countrycode, statename).
      then(response => {
        if (response.data.type === "")
          response.data.type = "state"
        context.commit('setDetailObject', response.data)
       })
    },
    async fetchCityList(context, {countrycode, statename}){
      await EarthService.getCities(countrycode, statename).
      then(response => {
        context.commit('setFetchedList', response.data)
       })
    },
    async fetchCityDetail(context, {countrycode, statename, cityname}){
      await EarthService.getCityInfo(countrycode, statename, cityname).
      then(response => {
        context.commit('setDetailObject', response.data)
       })
    }

  },
  modules: {
  }
})
