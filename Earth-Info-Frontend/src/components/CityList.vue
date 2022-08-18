<template>
    <div class="City">
        <h3>Cities</h3>
        <div class="cityListElement">
            <input type="text" v-model="search" style="margin: auto auto; width: 80%;" placeholder=" Search city...">
        </div>
        <p hidden>{{filteredList.length}}</p>
        <div v-if="cityList.length">
            <div v-for="city in filteredList" :key="city" >
                <div class="cityListElement">
                    <p style="margin-top: 10px; float: left">{{city.name}}</p>
                    <button @click="getCityInfo(getselectedCountryCode, getselectedStateName, city.name )"
                    data-bs-toggle="modal" data-bs-target="#detailsModal">
                        <img src="../assets/icons/icons8_info_100px_1.png" width="30" height="30">
                    </button>
                </div>
            </div>
        </div>
        <div v-else-if="getselectedStateName.length === 0">
            <h3>Please select a state.</h3>
        </div>
        <div v-else>
            <h3>No city found.</h3>
        </div>
    </div>

    <Details />

</template>

<script>
import Details from './Details.vue'
import { mapGetters, mapActions } from 'vuex'

export default {
    name: 'City',
    components: { Details,  },
    data(){
        return{
            cityList: [],
            search: '',
            currentState: '',
            currentCountry: '',
        }
    },
    methods: {
        async getCityList(countrycode, statename){
            await this.fetchCityList({countrycode, statename})
            this.cityList = this.getfetchedList
            this.currentState = statename
            this.currentCountry = countrycode
        },
        async getCityInfo(countrycode, statename, cityname){
            await this.fetchCityDetail({countrycode, statename, cityname})
        },
        ...mapActions(["fetchCityList", "fetchCityDetail"])
    },
    
    computed: {
        ...mapGetters(['getselectedCountryCode', 'getselectedStateName', 'getdetailObject', "getfetchedList"]),
        filteredList: function(){
            if(this.currentState != this.getselectedStateName) {
                this.search = ''
                this.getCityList(this.getselectedCountryCode, this.getselectedStateName)
            }
            if(this.currentCountry != this.getselectedCountryCode){
                this.cityList = []
                return []
            }

            return this.cityList.filter(item => item.name.toLowerCase().includes(this.search.toLowerCase()))

        },
    },
}
</script>

<style scoped>

.City h3 {
    background: #ecececee;
    padding: 20px;
    border-radius: 10px;
    color: #444;
}

.cityListElement {
    height: 65px;
    background: #ecececee;
    padding: 20px;
    border-radius: 10px;
    margin: 10px auto;
    color: #444;
    text-align: left;
    display: flex;
    align-items: center;
    justify-content: space-between;
    width: 100%;
    margin-top: 10px;
}

.cityListElement:hover {
    background: crimson;
    color: white
}

.City button{
    border: 0;
    float: right;
    background: transparent;
}

</style>