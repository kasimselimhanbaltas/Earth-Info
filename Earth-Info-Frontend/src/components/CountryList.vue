<template>
    <div class="Country">
        <h3 >Countries</h3>
        <div class="countryListElement" style="height: 65px; ">
            <input type="text" v-model="search" style="margin: auto auto; width: 80%;" placeholder=" Search country...">
        </div>
        <div v-if="filteredList.length">
            <div v-for="country in filteredList" :key="country.name" >
                <div class="countryListElement">
                    <p style="margin-top: 10px; margin-left: 10px; float: left">
                        {{country.name}} |
                        <span class="badge bg-secondary">
                            {{country.iso2}}
                        </span>
                    </p>
                   <div>
                     <button @click.stop="setselectedCountryCode(country.iso2)" >
                        <img src="../assets/icons/icons8_arrow_100px.png" width="30" height="30">
                    </button>
                    <button @click.stop="getCountryInfo(country.iso2)"
                    data-bs-toggle="modal" data-bs-target="#detailsModal">
                        <img src="../assets/icons/icons8_info_100px_1.png" width="30" height="30" >
                    </button>
                   </div>

                </div>
            </div>
        </div>
        <div v-else style="margin-top: 10px;">
            <h3>Error fetching data.</h3>
        </div>
    </div>
    <Details />

</template>


<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import Details from './Details.vue'

export default {
    name: "Country",
    components: { Details,  },
    data() {
        return {
            countryList: [],
            search: "",
            currentCountry: "",
        };
    },
    created() {
        this.getCountries();
    },
    methods: {
        async getCountries() {
            await this.fetchCountryList()
            this.countryList = this.getfetchedList
        },
        async getCountryInfo(iso2) {
            await this.fetchCountryDetail(iso2)
        },
        ...mapMutations([ "setselectedCountryCode", "setDetailObject"]),
        ...mapActions(["fetchCountryList", "fetchCountryDetail"]),
    },
    
    computed: {
        ...mapState(["selectedCountryCode"]),
        ...mapGetters(["getfetchedList"]),

        filteredList: function () {
            return this.countryList.filter(item => item.name.toLowerCase().includes(this.search.toLowerCase()));
        }
    },
}
</script>


<style scoped>

.Country h3 {
    background: #ecececee;
    padding: 20px;
    border-radius: 10px;
    color: #444;
}
.countryListElement {
    background: #ecececee;
    padding: 10px;
    border-radius: 10px;
    color: #444;
    text-align: left;
    display: flex;
    align-items: center;
    justify-content: space-between;
    width: 100%;
    margin-top: 10px;
}
.countryListElement:hover {
    background: crimson;
    color: white;
}
.Country button{
    border: 0;
    float: right;
    background: transparent;
}

</style>

