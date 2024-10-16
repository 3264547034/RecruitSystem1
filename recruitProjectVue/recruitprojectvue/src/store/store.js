import Vue from 'vue';  
import Vuex from 'vuex'
import {getInfo,setInfo,removeInfo} from "./modules/storage"
import createPersistedState from 'vuex-persistedstate'
Vue.use(Vuex)

export default new Vuex.Store({
    state:{
        token: getInfo()
    },
    mutations:{
        setToken(state,token){
            state.token = token;
            setInfo(token)
        },
        removeToken(state){
            state.token = '';
            removeInfo()
        }

    },
    actions:{

    },
    getters:{

    },
    


});


