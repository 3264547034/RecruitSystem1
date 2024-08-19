<template>
        <div id="building">
            <div id="test">
            <el-container style="height: 500px; border: 1px solid #eee">
                <el-header width="200px" style=".el-header">招聘管理系统</el-header>
            <el-container style="height: 500px; border: 1px solid #eee">
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
                        <el-button type="primary" round  @click="setInsertDialog">新增</el-button>
                    </el-container>
                    <!-- 新增表单 -->
                    <el-dialog title="新增部门" :visible.sync="insertDialog">
                            <el-form :model="insert" >
                                        <el-form-item label="id" >
                                            <el-input v-model="insert.id" ></el-input>
                                        </el-form-item>
                                        <el-form-item label="名称" >
                                            <el-input v-model="insert.name" ></el-input>
                                        </el-form-item>
                                        <el-form-item label="职责" >
                                            <el-input v-model="insert.duty" ></el-input>
                                        </el-form-item>
                                        <el-form>
                                            <el-button type="primary" @click="insertDpt">确 定</el-button>
                                            <el-button type="danger" @click="insertDialog = false">取 消</el-button>
                                        </el-form>
                                        </el-form>
                                    </el-dialog>


                    <!-- 表单数据 -->
                    <el-table :data="dptData" >
                        <el-table-column prop="id" label="部门号" width="200">
                        </el-table-column>
                        <el-table-column prop="name" label="部门名称" width="200">
                        </el-table-column>
                        <el-table-column prop="duty" label="部门职责" width="200">
                        </el-table-column>
                        <el-table-column fixed="right" label="操作" width="200">
                                <template slot-scope="scope">
                                    <el-button type="primary" @click="setUpdateDialog(scope.row)" icon="el-icon-edit" round size="small">编辑</el-button>
                                    <el-button type="danger" @click="deleteDpt(scope.row.id)" icon="el-icon-delete-solid" round size="small">删除</el-button>
                                </template>
                            </el-table-column>
                    </el-table>

                    <!-- 更新表单 -->
                    <el-dialog title="编辑部门" :visible.sync="updateDialog">
                            <el-form :model="update" >
                                        <el-form-item label="id" >
                                            <el-input v-model="update.newId" ></el-input>
                                        </el-form-item>
                                        <el-form-item label="名称" >
                                            <el-input v-model="update.name" ></el-input>
                                        </el-form-item>
                                        <el-form-item label="职责" >
                                            <el-input v-model="update.duty" ></el-input>
                                        </el-form-item>
                                        <el-form>
                                            <el-button type="primary" @click="updateDpt">确 定</el-button>
                                            <el-button type="danger" @click="updateDialog = false">取 消</el-button>
                                        </el-form>
                                        </el-form>
                                    </el-dialog>
                </el-main>
            </el-container>
            </el-container>
            </div>
        </div>
     
</template>
<script>
import axios from 'axios';

    export default{
            inject:['reload'],
            data(){
                return {
                    //表格数据
                    accountData: [],
                    //更新数据
                    update:{
                        uid:null,
                        password:null,
                    },
                    insert:{
                        uid:null,
                        password:null,
                    },
                    updateDialog:false,
                    insertDialog:false,
                }

            },
            methods: {
                //编辑
                setUpdateDialog(row){  //数据回显
                    this.update.newId = row.id;
                    this.update.id = row.id;
                    this.update.name = row.name;
                    this.update.duty = row.duty;
                    this.updateDialog = true;
                },
                updateDpt(){
                    const requestBody = {
                        ...this.update,
                    }
                    axios.put("http://localhost:8080/departments",requestBody).then((result)=>{
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
                    }).catch(error => {  
                    // 请求失败时处理错误  
                    console.error('查询失败:', error);  
                    // 可以在这里设置this.result为错误消息或null  
                    this.result = null;  
                    });
                    this.updateDialog = false;
                    this.reload();
                },
                //删除
                deleteDpt(id){
                const url = `http://localhost:8080/departments/${id}`;
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
                }).catch(error => {  
                    // 捕获错误  
                    if (error.response) {  
                    // 服务器响应了请求，但返回了错误状态码  
                    // 你可以在这里访问 error.response.status 来获取状态码  
                    this.$message(error.response.status);  
                    this.$message(error.response.data); // 响应体  
                    } else if (error.request) {  
                    // 请求已经发起，但没有收到响应  
                    this.$message(error.request);  
                    } else {  
                    // 设置请求时触发了错误  
                    this.$message('Error', error.message);  
                    }  
                });
                //刷新页面  
                this.reload();
                },
                //新增
                setInsertDialog(){
                    this.insertDialog=true;
                },
                insertDpt(){
                const requestBody = {
                    ...this.insert,
                }
                axios.post("http://localhost:8080/departments",requestBody).then((result)=>{
                    if(result.data.code=="1") {
                        this.$message({
                            type: "success",
                            message: "新增成功",
                        });
                    }
                    else {
                        this.$message({
                            type: "error",
                            message: "新增失败",
                        });
                    }
                });
                this.reload();

                }

            },
            mounted(){
                axios.get("http://localhost:8080/departments").then((result)=>{
                    this.dptData = result.data.data;
                });

            }

    }
</script>
<style>
    .el-header {
        background-color: #B3C0D1;
        color: #333;
        line-height: 60px;
    }
    

    
    .test{
    opacity:0.7;
    }

    
    .el-aside {
        color: #333;
    }


</style>