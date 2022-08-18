<template>
    <div class="State">
        <h3 >States</h3>
        <div class="stateListElement">
            <input type="text" v-model="search" style="margin: auto auto; width: 80%;" placeholder=" Search state...">
        </div>
        <p hidden>{{filteredList}}</p>
        <div v-if="stateList.length">
            <div v-for="state in filteredList" :key="state.name" >
                <div class="stateListElement">
                    <p style="margin-top: 10px; float: left">{{state.name}}</p>
                    <div>
                        <button @click="setselectedStateName(state.name)">
                        <img src="../assets/icons/icons8_arrow_100px.png" width="30" height="30">
                    </button>
                    <button @click="getStateInfo(getselectedCountryCode, state.name)"
                    data-bs-toggle="modal" data-bs-target="#detailsModal">
                        <img src="../assets/icons/icons8_info_100px_1.png" width="30" height="30">
                    </button>
                    </div>
                </div>
            </div>
        </div>
        <div v-else-if="this.getselectedCountryCode.length === 0">
            <h3>Please select a country.</h3>
        </div>
        <div v-else>
            <h3>No state found.</h3>
        </div>
    </div>
    <Details />




</template>

<script>
import Details from './Details.vue'
import { mapGetters, mapMutations, mapActions } from 'vuex'


export default {
    name: 'State',
    components: { Details  },
    data() {
        return{
            stateList: [],
            search: '',
            currentState: '',
        }
    },
    methods: {
        async getStates(countrycode){
            await this.fetchStateList(countrycode)
            this.stateList = this.getfetchedList
            this.currentState = countrycode
        },
        async getStateInfo(countrycode, statename){
            await this.fetchStateDetail({countrycode, statename})
        },
        ...mapMutations(['setselectedStateName', "setDetailObject", "setFetchedList"]),
        ...mapActions(["fetchStateList", "fetchStateDetail" ])
    },

    computed: {
        ...mapGetters(['getselectedCountryCode', 'getselectedStateName', "getdetailObject", "getfetchedList"]),
        filteredList: function(){
            if(this.currentState!=this.getselectedCountryCode){
                this.search = ''
                this.getStates(this.getselectedCountryCode)
            }
            return this.stateList.filter(item => item.name.toLowerCase().includes(this.search.toLowerCase()))
        },
    },

}
</script>


<style scoped>
.State h3 {
    background: #ecececee;
    padding: 20px;
    border-radius: 10px;
    color: #444;
}
.stateListElement {
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
.stateListElement:hover {
    background: crimson;
}
.State button{
    border: 0;
    float: right;
    background: transparent;
}
</style>