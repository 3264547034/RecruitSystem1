import Vue from 'vue'
import VueRouter from 'vue-router'
import dptView from '@/views/RecruitSystem/AdminView/dptView.vue'
import { Result } from 'element-ui'

Vue.use(VueRouter)

const routes = [
  {
    path: '/dpt',
    name: 'dpt',
    component: dptView
  },
  {
    path: '/jobseeker',
    name: 'jobseeker',
    component: () => import('../views/RecruitSystem/AdminView/jobseekerView.vue')
  },
  {
    path: '/login',
    name: '/login',
    component: () => import('../views/RecruitSystem/LoginView/LoginView.vue')
  },
  {
    path: '/',
    redirect: '/dpt'
  },
  {
    path: '/job',
    name: 'job',
    component: () => import('../views/RecruitSystem/AdminView/jobView.vue')
  },
  {
    path: '/accountJobseeker',
    name: 'accountJobseeker',
    component: () => import('../views/RecruitSystem/AdminView/jobseekerAccount.vue')
  },
  {
    path: '/accountHR',
    name: 'accountHR',
    component: () => import('../views/RecruitSystem/AdminView/HRAccount.vue')
  },
  
]

const router = new VueRouter({
  routes
})
import axios from 'axios'
// // 路由守卫 
// router.beforeEach((to,from,next)=>{
//   console.log('Checking token for path:', to.path); // 打印当前要访问的路径  
//   let token = localStorage.getItem("token");
//   //console.log('Token:', token); // 打印token值
//   const requestBody = token
//   let result;
//   axios.post("http://localhost:8080/VerifyToken",requestBody).then((result)=>{
//     // if(result.data.code==="1" || to.path === "/login"){
//     //   next();
//     // }
//     // else{
//     //   next("/login");
//     // }
//     this.result  = result.data.code
//   })
//   if(result || to.path === "/login"){
//     next();
//   }
//   else{
//     next("/login");
//   }
// })

router.beforeEach((to, from, next) => {  
  console.log('Checking token for path:', to.path); // 打印当前要访问的路径  
  let token = localStorage.getItem("token");  
  //console.log('Token:', token); // 打印token值  
  
  if (!token && to.path !== "/login") {  
    // 如果没有 token 并且不是登录页面，则重定向到登录页面  
    console.log("没有 token 并且不是登录页面，重定向到登录页面 ")
    next("/login");  

  } else {  
    // 访问的是登录界面，继续执行 
    if(to.path === "/login"){
      next();
    }
    else{ //访问的其他界面，验证token
      axios.post("http://localhost:8080/VerifyToken", token).then((result) => {  
        if (result.data.code === 1) {  
          // 如果 token 验证通过，继续路由  
          next();  
        } else {  
          // 如果 token 验证失败，重定向到登录页面  
          console.log("token验证失败即将返回到登录页面")
           next("/login");  //报错了
        }  
      })  
    }
  }  
});

export default router
