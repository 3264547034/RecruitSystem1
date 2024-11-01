<template>
<body>
  <div class="header">
    <h1><sHeader></sHeader></h1>
    </div>
  <div class="container">
    <div class="lside">
      <h1><sAside></sAside></h1>
      </div>
    <div class="main">主内容</div>
  </div>
  <div class="footer">底部</div>
</body>

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
  *{
    margin: 0;
    padding: 0;
    text-decoration: none;
    list-style: none;
  }
  .header,.nav,.container,.footer{
    float:left;
    width: 100%;
  }
  .header{
    background: rgb(144, 132, 132);
    padding: 20px;
    text-align: center;
  }
  .lside{
    width: 200px;
    float: left;

  }
  .main{
    width: 200px;
    float: right;
    margin:0px 205px;
  }
  .lside,.main{
    padding: 5px;
  }
  .footer{
    padding: 10px;
    background: pink;
    text-align: center;
  }



    
</style>
