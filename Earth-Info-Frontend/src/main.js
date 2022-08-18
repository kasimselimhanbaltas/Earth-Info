import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap.js'
import store from './store'
import JsonViewer from 'vue-json-viewer'
import 'vue-json-viewer/style.css'

createApp(App).use(router).use(store).use(JsonViewer).mount('#app')
document.title = "Earth Info"



