<template> 

        <div>
            <span class="title">招聘管理系统</span>
                <el-button type="primary" round  @click="logOUt" class="button">退出登录</el-button>

        </div>
</template>

<script>
export default {

    methods:{
        //退出登录
                logOUt(){
                    this.$store.commit("removeToken")
                    this.$router.push('/login')
                    this.$message({
                            type: "success",
                            message: "退出成功",
                        });
                }
    }
}
</script>

<style scoped>
    .button{
        float: right;
    }
    .title{
        text-align: center;
    }
    

</style>