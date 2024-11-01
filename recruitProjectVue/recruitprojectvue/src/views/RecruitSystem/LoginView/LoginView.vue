<template>
  <el-container class="custom-container">
    <el-main>
      <div class="login-container">
        <h2>用户登录</h2>
        <div v-if="errorMessage" class="error-message">
          {{ errorMessage }}
        </div>
        <form @submit.prevent="confirm" class="login-form">
          <input type="text" v-model="uid" placeholder="用户名" required>
          <div class="password-container">
            <input
              :type="showPassword ? 'text' : 'password'"
              v-model="password"
              placeholder="密码"
              required
            />
            <button type="button" class="toggle-password" @click="togglePassword">
              {{ showPassword ? '隐藏' : '显示' }}
            </button>
          </div>
 
          <!-- 新增的注册提示 -->
          <div class="register-prompt">
            没有用户？ 
            <router-link to="/login" class="register-link">点击注册</router-link>
          </div>
 
          <button type="submit">登录</button>
        </form>
      </div>
    </el-main>
  </el-container>
</template>

<script>
    import axios from 'axios';
    import vuex from 'vuex';
      export default {
        name: "loginView",
        data(){
            return{
                uid:'',
                password:'',
                errorMessage: '',  // 错误信息
                successMessage: '', // 成功信息
                showPassword: false, // 控制密码是否明文显示
            }
        },
        methods:{
            confirm(){
                const requestBody = {
                    uid: this.uid,
                    password: this.password
                }
                //axios异步请求向服务器发送post请求
                axios.post("http://localhost:8080/login",requestBody).then((result)=>{
                    if(result.data.code!='1'){
                        this.$message({
                            type: "error",
                            message: "用户名或密码错误",
                        });
                    }
                    else{
                        //设置token并重定向到部门页面
                        this.$message({
                            type: "success",
                            message: "登录成功",
                        });
                        this.$store.commit("setToken",result.data.data)
                        console.log("令牌已经存入localStorage中")
                        this.$router.push('/dpt')
                    }
                })

            },
            togglePassword() {
                this.showPassword = !this.showPassword;
            },
        }
    }
</script>

<style scoped>
body {
  font-family: Arial, sans-serif;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  margin: 0;
  background-color: #f0f0f0;
}
 
.el-main {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
.login-container {
  background-color: rgba(255, 255, 255, 0.8); /* 半透明白色背景 */
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  max-width: 400px; /* 调整表单的最大宽度 */
  width: 100%; /* 确保容器宽度根据屏幕自适应 */
  height: 350px;
  margin: auto;
  box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2); /* 增强阴影效果 */
  border: 1px solid #ccc; /* 添加边框 */
}
.custom-container {
  height: 100vh; /* 使容器高度等于视口高度 */  
  width: 100vw;  /* 使容器宽度等于视口宽度 */  
  border: 1px solid #eeeeee;  
  background-image: url('../../../assets/loginPicture2.png');  
  background-size: cover; /* 背景图片覆盖整个容器 */  
  background-position: center; /* 背景图片居中 */  
  margin: 0; /* 移除任何默认的外边距 */  
  padding: 0; /* 移除任何默认的内边距 */  
  box-sizing: border-box; /* 确保内边距和边框不会增加容器的总尺寸 */  
  overflow: hidden; /* 防止内容溢出容器 */ 
}
 
h2 {
  text-align: center;
  color: #333;
}
form {
  display: flex;
  flex-direction: column;
  align-items: center; /* 让输入框和按钮居中 */
}
.password-container {
  display: flex;
  align-items: center;
  position: relative;
  width: 100%;
  max-width: 300px;
  border-radius: 4px;
}
input {
  width: 100%;
  max-width: 300px;
  margin: 10px 0;
  padding: 12px;
  border: 1px solid #ddd;
  border-radius: 4px;
  box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.1);
  box-sizing: border-box;
  transition: box-shadow 0.3s ease;
}
input:focus {
  box-shadow: 0 0 8px rgba(74, 144, 226, 0.5);
  border-color: #4A90E2;
}
.toggle-password {
  position: absolute;
  right: 10px;
  top: 50%;
  transform: translateY(-50%);
  background: none;
  border: none;
  color: #007bff;
  cursor: pointer;
  width: auto; /* 让按钮宽度自适应文字 */
  padding: 0;  /* 去掉内边距，避免撑开 */
  font-size: 14px; /* 控制文字大小 */
}
 
.register-prompt {
  text-align: right;
  width: 100%;
  max-width: 300px;
  font-size: 14px;
  color: #333;
  margin-bottom: 10px;
}
 
.register-link {
  color: #007bff;
  text-decoration: none;
  cursor: pointer;
}
.register-link:hover {
  text-decoration: underline;
}
 
button {
  background: linear-gradient(90deg, #4A90E2, #9013FE); /* 渐变色按钮 */
  color: white;
  padding: 10px;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  box-shadow: 0 8px 10px rgba(0, 0, 0, 0.2);
}
button:hover {
  background: linear-gradient(90deg, #357ABD, #7316E5); /* 鼠标悬浮时颜色变化 */
}
 
.error-message {
  color: red;
  text-align: center;
}
    
</style>
