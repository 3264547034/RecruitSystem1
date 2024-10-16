<template>
    <el-container style="height: 500px; border: 1px solid #eee">
                <el-header>
                    <sHeader></sHeader>
                </el-header>
            <el-container style="height: 500px; border: 1px solid #eee">
                <sAside></sAside>
                <jobseekerMain></jobseekerMain>
            </el-container>
            </el-container>
</template>
<script>
import jobseekerMain from '../../components/jobseekerMain.vue'

export default{
    components:{
        jobseekerMain,
    }

}
</script>
<style>
</style>