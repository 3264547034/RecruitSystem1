<template>
                    <el-menu :default-openeds="['1', '3']">
                        <el-submenu index="1">
                        <template slot="title"><i class="el-icon-message"></i>招聘管理系统</template>
                        <el-menu-item-group>
                        <template slot="title">招聘信息管理</template>
                        <el-menu-item index="1-1">
                            <router-link to="/dpt">招聘部门管理</router-link>
                        </el-menu-item>
                        <el-menu-item index="1-2">
                            <router-link to="/jobseeker">简历管理</router-link>
                        </el-menu-item>
                        <el-menu-item index="1-3">
                            <router-link to="/job">岗位管理</router-link>
                        </el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                    <el-submenu index="2">
                        <template slot="title">
                            <i class="el-icon-user-solid"></i>
                            <span>账号管理</span>
                        </template>
                        <el-menu-item-group title="账号管理">
                        <el-menu-item index="2-1">
                            <router-link to="/accountJobseeker">应聘者账号管理</router-link>
                        </el-menu-item>
                        <el-menu-item index="2-2">
                            <router-link to="/accountHR">HR账号管理</router-link>
                        </el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                    </el-menu>
</template>

<script>
export default {

}
</script>

<style>


</style>