<template>
    <div class="loginbBody">
        <div class="loginDiv">
            <div class="login-content">
                <h1 class="login-title">用户登录</h1>
                <el-form :model="loginForm" label-width="100px"
                         :rules="rules" ref="loginForm">
                    <el-form-item label="名字" prop="uid">
                        <el-input style="width: 200px" type="text" v-model="loginForm.uid"
                                  autocomplete="off" size="small"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input style="width: 200px" type="password" v-model="loginForm.password"
                                  show-password autocomplete="off" size="small"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="confirm">确 定</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>
    import axios from 'axios';
    import vuex from 'vuex';
    import persistedState from 'vuex-persistedstate'
      export default {
        name: "loginView",
        data(){
            return{
                loginForm:{
                    uid:'',
                    password:''
                },
                token:'',
                rules:{
                  name: [
                            { required: true, message: '请输入用户名', trigger: 'blur' },
                            { min: 3, max: 6, message: '用户名长度在 3 到 6 个字符', trigger: 'blur' }
                        ],
                        password: [
                            { required: true, message: '请输密码', trigger: 'blur' },
                            { min: 3, max: 6, message: '密码长度在 3 到 6 个字符', trigger: 'blur' }
                        ]
                }
            }
        },
        methods:{
            confirm(){
                const requestBody = {
                    ...this.loginForm,
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
                        localStorage.setItem("token",result.data.data)
                        this.$store.token = result.data.data
                        console.log("令牌已经存入localStorage中")
                        this.$router.push('/dpt')
                    }
                })

            }
        }
    }
</script>

<style scoped >
    .loginbBody {
        width: 100%;
        height: 100%;
        background-color: #B3C0D1;
    }
    .loginDiv {
        position: absolute;
        top: 50%;
        left: 50%;
        margin-top: -200px;
        margin-left: -250px;
        width: 450px;
        height: 330px;
        background: #fff;
        border-radius: 5%;

    }
    .login-title {
        margin: 20px 0;
        text-align: center;
    }
    .login-content {
        width: 400px;
        height: 250px;
        position: absolute;
        top: 25px;
        left: 25px;
    }
</style>