<template>
    <!-- Modal -->
<div class="modal fade" id="detailsModal" data-bs-keyboard="false" 
tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">{{getdetailObject.name}}'s Details</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <json-viewer 
          :value="getdetailObject"
          theme="my-awesome-json-theme"
          style="
          text-align:left; 
          border: ridge;
          border-style: solid;
          border: 2px;
          border-radius: 10px;"
          ></json-viewer>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
</template>


<script>
import { mapGetters } from 'vuex'

export default {
    name: 'Details',
    computed: {
      ...mapGetters([ "getdetailObject"])
    }
}
</script>


<style scoped>
.modal {
  --bs-modal-margin: 50px;
}
.modal-title{
  margin-left: auto;
}
.modal-body .json-viewer {
  margin-top: 0px;
  margin-bottom: 0px;
  font-size: 12px;
  text-align: left;
  width: 400px;
  padding: 20px;
  border-radius: 10px;
}
.my-awesome-json-theme {
  word-break: 'break-word';
  background: rgb(217, 216, 216);
  font-size: 14px;
  font-family: Consolas, Menlo, Courier, monospace;
}

</style>