<template>
  <div>

      <!-- <router-view></router-view> -->
      <router-view v-if="isRouterAlive"></router-view>
  </div>
</template>

<script>
      export default{
          provide () {    //父组件中通过provide来提供变量，在子组件中通过inject来注入变量。                                             
              return {
                  reload: this.reload                                              
              }
          },
          data(){
            return{
              message:"hello world",
              isRouterAlive: true                    //控制视图是否显示的变量
            }

          },
          methods: {
            reload () {
                this.isRouterAlive = false;            //先关闭，
                this.$nextTick(function () {
                    this.isRouterAlive = true;         //再打开
                }) 
            }
        },
      }

</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
