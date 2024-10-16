<template>
            <el-container>
                <el-header><sHeader></sHeader></el-header>
                <el-container>
                    <el-aside width="200px"><sAside></sAside></el-aside>
                    <el-container>
                    <el-main><dptMain></dptMain></el-main>
                    <el-footer>Footer</el-footer>
                    </el-container>
                </el-container>
            </el-container>
            
</template>
<script>


import dptMain from '../../components/dptMain.vue'
    export default{
        components:{
            dptMain,
        },
    }
</script>
<style>
.el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 120px;
  }
  
  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }
  
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }
  
  body > .el-container {
    margin-bottom: 40px;
  }
  
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }
  
  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }

</style>