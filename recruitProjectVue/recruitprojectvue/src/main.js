import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios';
Vue.prototype.$axios = axios
Vue.use(ElementUI);
Vue.config.productionTip = false

new Vue({
  axios,
  router,
  render: h => h(App)
}).$mount('#app')

/*引入axios*/
import Axios from "axios";

Vue.prototype.axios = Axios;

// 添加请求拦截器，在请求头中加token
Axios.interceptors.request.use(
  config => {
    const token = localStorage.getItem("token")
      if(token&&config.url!="http://localhost:8080/login"){
        config.headers.Authorization = localStorage.getItem("token");
      }
    return config;
  },
  error => {
    return Promise.reject(error);
  }
);
