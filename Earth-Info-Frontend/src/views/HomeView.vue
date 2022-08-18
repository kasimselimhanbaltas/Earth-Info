<template>
  <div class="topnav" >
    <div style="display: inner-block; margin-top: 9px">
      <Header />
    </div>
  </div>
<body>
  <div class="container">
    <div class="row" >

      <div class="col" style="margin-top: 40px">
        <CountryList />
      </div>
      <div class="col" style="margin-top: 40px"> 
       <StateList />
      </div>
      <div class="col" style="margin-top: 40px">
        <CityList />
      </div>

    </div>
  </div>
</body>

</template>


<script>

import Header from '@/components/Header.vue'
import CountryList from '@/components/CountryList.vue'
import StateList from '@/components/StateList.vue'
import CityList from '@/components/CityList.vue'

export default {
  name: 'HomeView',

  components: {
    CountryList,
    StateList,
    CityList,
    Header,
  },
  }
</script>

<style scoped>

.topnav {
  background-color: darkblue;
  overflow: hidden;
  height: 60px;
  text-align: center;
}
.topnav h2{
  color: white;
  font-style: Timesn;
}

</style>
