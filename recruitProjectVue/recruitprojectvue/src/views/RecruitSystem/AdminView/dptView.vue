<template>
    <el-container>
        <el-header class="el-header">
            <sHeader></sHeader>
        </el-header>
        <el-container>
            <el-aside class="el-aside">
                <sAside></sAside>
            </el-aside>
            <el-main class="el-main">
                <dptMain></dptMain>
            </el-main>
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
<style scoped>
.el-header {
    background: #3d5afe; /* 改为统一的蓝色背景 */
    padding: 20px; /* 增加内边距 */
    color: white; /* 修改文字颜色为白色 */
    text-align: center; /* 居中对齐标题 */
}
.title {
    margin: 0; /* 删除默认的外边距 */
}
.el-aside {
    width: 250px; /* 设定固定宽度 */
    background: #f4f4f4; /* 设置背景颜色 */
    border-right: 1px solid #e0e0e0; /* 添加右边框 */
}
.el-main {
    padding: 20px; /* 增加内边距 */
    background: #ffffff; /* 白色背景 */
}

</style>