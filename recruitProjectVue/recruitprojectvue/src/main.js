import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios';
import store from './store/store';

import commonComponents from './views/components/commonComponents';


Vue.prototype.$axios = axios
Vue.use(ElementUI);
Vue.config.productionTip = false
Vue.use(commonComponents)
new Vue({
  store,
  axios,
  router,
  render: h => h(App)
}).$mount('#app')







