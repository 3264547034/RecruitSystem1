<template>
    
    <div>
        <el-container>
            <el-header width="200px" style=".el-header">招聘管理系统</el-header>
        <el-container class=".el-header">
            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
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
                </el-aside>
            <el-main>
                <el-container>
                        <!-- 查询表单 -->
                        <el-form :inline="true" :model="search">
                                <el-form-item label="id">
                                    <el-input v-model="search.id" placeholder="岗位id"></el-input>
                                </el-form-item>
                                <el-form-item label="名称">
                                    <el-input v-model="search.name" placeholder="岗位名称"></el-input>
                                </el-form-item>
                                <el-form-item label="岗位类型">
                                    <el-select v-model="search.techtype" placeholder="请选择岗位类型">
                                        <el-option label="不限"></el-option>
                                        <el-option
                                            v-for="item in jobs"
                                            :key="item.key"
                                            :label="item.label"
                                            :value="item.value">
                                        </el-option>
                                    </el-select>
                                </el-form-item>
                                <el-form-item label="归属部门">
                                            <el-select v-model="search.dptId" placeholder="请选择部门">
                                                <el-option label="不限" value = null></el-option>
                                                <el-option
                                                    v-for="item in dpts"
                                                    :key="item.key"
                                                    :label="item.label"
                                                    :value="item.value">
                                                </el-option>
                                            </el-select>
                                        </el-form-item>
                                <!-- 查询选项 -->
                                <el-form-item>
                                    <el-button type="primary" @click="searchJob" icon="el-icon-zoom-in">查询</el-button>
                                </el-form-item>
                                
                                <!-- 新增选项 -->
                                <el-form-item>
                                    <el-button type="primary" @click="setInsertDialog" icon="el-icon-plus">新增</el-button>
                                </el-form-item>
                            </el-form>
                            <!-- 新增对话框 -->
                            <el-dialog title="新增岗位" :visible.sync="insertDialog">
                            <el-form :model="insert" >
                                        <el-form-item label="岗位id" >
                                            <el-input v-model="insert.id" ></el-input>
                                        </el-form-item>
                                        <el-form-item label="名称" >
                                            <el-input v-model="insert.name" ></el-input>
                                        </el-form-item>
                                        <el-form-item label="岗位类型">
                                            <el-input v-model="insert.techtype" ></el-input>
                                        </el-form-item>
                                        <el-form-item label="招聘人数" :rules="[{ required: true, message: '人数不能为空'},{ type: 'number', message: '人数必须为数字值'}]">
                                            <el-input v-model.number="insert.num"></el-input>
                                        </el-form-item>
                                        <el-form-item label="部门归属" >
                                            <el-select v-model="insert.dptId" placeholder="请选择部门">
                                                <el-option
                                                    v-for="item in dpts"
                                                    :key="item.key"
                                                    :label="item.label"
                                                    :value="item.value">
                                                </el-option>
                                            </el-select>
                                        </el-form-item>
                                        <el-form>
                                            <el-button type="primary" @click="insertJob">确 定</el-button>
                                            <el-button @click="insertDialog = false">取 消</el-button>
                                        </el-form>
                                        </el-form>
                                    </el-dialog>
                                </el-container>
                        
                        <!-- 数据表格 -->
                        <el-table :data="jobsData"  >
                            <el-table-column prop="id" label="id" width="200">
                            </el-table-column>
                            <el-table-column prop="name" label="名称" width="200">
                            </el-table-column>
                            <el-table-column prop="techtype" label="岗位类型" width="200">
                            </el-table-column>
                            <el-table-column prop="num" label="剩余招聘人数" width="200">
                            </el-table-column>
                            <el-table-column prop="dptName" label="归属岗位" width="200">
                            </el-table-column>
                            <el-table-column fixed="right" label="操作" width="200">
                                <template slot-scope="scope">
                                    <el-button type="primary" @click="setUpdateDialog(scope.row)" icon="el-icon-edit" round size="small">编辑</el-button>
                                    <el-button type="danger" @click="deleteJob(scope.row.id)" icon="el-icon-delete-solid" round size="small">删除</el-button>
                                </template>
                            </el-table-column>
                        </el-table>
                        <!-- 更新表单 -->
                        <el-dialog title="编辑简历" :visible.sync="updateDialog" class="dialogStyle">
                            <el-form :model="update" >
                                        <el-form-item label="id" >
                                            <el-input v-model="update.newId" ></el-input>
                                        </el-form-item>
                                        <el-form-item label="名称" >
                                            <el-input v-model="update.name" ></el-input>
                                        </el-form-item>
                                        <el-form-item label="岗位类别" >
                                            <el-input v-model="update.techtype" ></el-input>
                                        </el-form-item>
                                        <el-form-item label="招聘人数" :rules="[{ required: true, message: '人数不能为空'},{ type: 'number', message: '人数必须为数字值'}]">
                                            <el-input v-model.number="update.num"></el-input>
                                        </el-form-item>
                                        <el-form-item label="归属部门">
                                            <el-select v-model="update.dptId" placeholder="请选择部门">
                                                <el-option
                                                    v-for="item in dpts"
                                                    :key="item.key"
                                                    :label="item.label"
                                                    :value="item.value">
                                                </el-option>
                                            </el-select>
                                        </el-form-item>
                                        <el-form>
                                            <el-button type="primary" @click="updateJob">确 定</el-button>
                                            <el-button @click="updateDialog = false">取 消</el-button>
                                        </el-form>
                                        </el-form>
                                    </el-dialog>
            </el-main>
        </el-container>
        </el-container>
    </div>
</template>
<script>
import axios from 'axios';

export default{
        inject:['reload'],
        data(){
            return {
                search:{
                    id:null,
                    name:null,
                    techtype:null,
                    num:null,
                    dptId:null
                },
                update:{
                    newId:null,
                    id:null,
                    name:null,
                    techtype:null,
                    num:null,
                    dptId:null
                },
                insert:{
                    id:null,
                    name:null,
                    techtype:null,
                    num:null,
                    dptId:null
                },
                dpts:[],
                jobs:[],
                jobsData: [],
                searchData:[],
                //更新对话框是否显示
                updateDialog: false,
                //新增对话框
                insertDialog: false,
                //图片url
            }
        },
        methods: {
            searchJob(){
                //封装请求体
                const requestBody = {
                    ...this.search,
                }
                //axios异步请求向服务器发送post请求
                axios.post("http://localhost:8080/jobs/search",requestBody).then((result)=>{
                    this.jobsData = result.data.data;
                }).catch(error => {  
                // 请求失败时处理错误  
                console.error('查询失败:', error);  
                // 可以在这里设置this.result为错误消息或null  
                this.result = null;  
                });
            },
            //删除方法
            deleteJob(id){
                const url = `http://localhost:8080/jobs/${id}`;
                axios.delete(url).then((result)=>{
                    if(result.data.code=="1") {
                        this.$message({
                            type: "success",
                            message: "删除成功",
                        });
                    }
                    else {
                        this.$message({
                            type: "error",
                            message: "删除失败",
                        });
                    }
                })
                //刷新页面
                this.reload();
            },
            //更新方法
            setUpdateDialog(row){
                this.update.newId = row.id
                this.update.id = row.id
                this.update.name = row.name
                this.update.techtype = row.techtype
                this.update.num = row.num
                this.update.dptId = row.dptId
                this.updateDialog = true;
            },
            updateJob(){
                const requestBody = {
                    ...this.update,
                }
                axios.put("http://localhost:8080/jobs",requestBody).then((result)=>{
                    if(result.data.code=="1") {
                        this.$message({
                            type: "success",
                            message: "更新成功",
                        });
                    }
                    else {
                        this.$message({
                            type: "error",
                            message: "更新失败",
                        });
                    }
                })
                this.updateDialog = false;
                this.reload();
            },
            //新增方法
            
            setInsertDialog(){
                this.insertDialog = true;
            },
            insertJob(){
                const requestBody = {
                    ...this.insert,
                }
                axios.post("http://localhost:8080/jobs",requestBody).then((result)=>{
                    if(result.data.code=="1") {
                        this.$message({
                            type: "success",
                            message: "新增成功",
                        });
                    }
                    else {
                        console.log(result.data.data)
                        this.$message({
                            type: "error",
                            message: result.data.message,
                        });
                    }
                });
                this.insertDialog=false;
                this.reload();
                
            },
            
        },
        mounted(){
            //加载岗位数据
            axios.get("http://localhost:8080/jobs/allJobs").then((result)=>{
                this.jobsData = result.data.data;
            });
            //加载岗位数据
            axios.get("http://localhost:8080/jobs/allJobs").then((result) => {  
                    this.jobs = result.data.data.map(job => ({  
                    value: job.techtype,  
                    label: job.techtype,  
                    }));  
                }).catch(error => {  
                    console.error('Error fetching jobs:', error);  
                });
            //加载部门数据
            axios.get("http://localhost:8080/departments").then((result) => {  
                    this.dpts = result.data.data.map(department => ({  
                    value: department.id,  
                    label: department.name,
                    
                    }));  
                }).catch(error => {  
                    console.error('Error fetching departments:', error);  
                });

        }

}
</script>
<style>
    .el-header {
    background-color: #d1c8b3;
    color: #333333;
    line-height: 60px;
    text-align:center;
    }

    .el-aside {
        color: #333333;
    }
    .dialogStyle {
        backdrop-filter: blur(10px) brightness(90%);
        background-color: rgba(255, 255, 255, 0.5);
        border-radius: 10px
    }

    
</style>