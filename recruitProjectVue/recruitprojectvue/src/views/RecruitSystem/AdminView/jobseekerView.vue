<template>
    <body>
    <div >
        <el-container class=".el-header">
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
                                    <el-input v-model="search.id" placeholder="应聘者id"></el-input>
                                </el-form-item>
                                <el-form-item label="姓名">
                                    <el-input v-model="search.name" placeholder="应聘者姓名"></el-input>
                                </el-form-item>
                                <el-form-item label="性别">
                                    <el-select v-model="search.sex" placeholder="选择性别">
                                        <el-option label="不限"></el-option>
                                        <el-option label="男" value="男"></el-option>
                                        <el-option label="女" value="女"></el-option>
                                    </el-select>
                                </el-form-item>
                                <el-form-item label="学历">
                                    <el-select v-model="search.degree" placeholder="选择学历">
                                        <el-option label="不限" ></el-option>
                                        <el-option label="大专" value="大专"></el-option>
                                        <el-option label="本科" value="本科"></el-option>
                                        <el-option label="硕士" value="硕士"></el-option>
                                        <el-option label="博士" value="博士"></el-option>
                                    </el-select>
                                </el-form-item>
                                <el-form-item label="应聘岗位" >
                                            <el-select v-model="search.jobId" placeholder="请选择岗位">
                                                <el-option
                                                    v-for="item in jobs"
                                                    :key="item.key"
                                                    :label="item.label"
                                                    :value="item.value"
                                                >
                                                </el-option>
                                            </el-select>
                                        </el-form-item>
                                <!-- 删除选项 -->
                                <el-form-item>
                                    <el-button type="primary" @click="searchjs" icon="el-icon-zoom-in">查询</el-button>
                                </el-form-item>
                                
                                <!-- 新增选项 -->
                                <el-form-item>
                                    <el-button type="primary" @click="insertdialog" icon="el-icon-plus">新增</el-button>
                                </el-form-item>
                            </el-form>
                            <el-dialog title="新增简历" :visible.sync="insertDialog">
                            <el-form :model="insert" >
                                        <el-form-item label="名称" >
                                            <el-input v-model="insert.name" ></el-input>
                                        </el-form-item>
                                        <el-form-item prop="image" label="上传图片" v-model="insert.image">
                                            <!-- 图片上传 -->
                                             <el-upload
                                                name = "file"
                                                :action="'http://localhost:8080/jobseekers/upload'"
                                                list-type="picture-card"
                                                limit="1"
                                                :on-exceed="limitError"
                                                :on-success="handleSuccess"
                                                :on-error="imgError"
                                            >
                                                <i class="el-icon-plus"></i>
                                            </el-upload>

                                        </el-form-item>
                                        <el-form-item label="性别">
                                            <el-select v-model="insert.sex" placeholder="请选择性别">
                                                <el-option label="男" value="男"></el-option>
                                                <el-option label="女" value="女"></el-option>
                                            </el-select>
                                        </el-form-item>
                                        <el-form-item label="年龄" :rules="[{ required: true, message: '年龄不能为空'},{ type: 'number', message: '年龄必须为数字值'}]">
                                            <el-input v-model.number="insert.age"></el-input>
                                        </el-form-item>
                                        <el-form-item label="学历">
                                            <el-select v-model="insert.degree" placeholder="请选择学历">
                                                <el-option label="大专" value="大专"></el-option>
                                                <el-option label="本科" value="本科"></el-option>
                                                <el-option label="硕士" value="硕士"></el-option>
                                                <el-option label="博士" value="博士"></el-option>
                                            </el-select>
                                        </el-form-item>
                                        <el-form-item label="专业" >
                                            <el-input v-model="insert.major" ></el-input>
                                        </el-form-item>
                                        <el-form-item label="应聘岗位" >
                                            <el-select v-model="insert.jobId" placeholder="请选择岗位">
                                                <el-option
                                                    v-for="item in jobs"
                                                    :key="item.key"
                                                    :label="item.label"
                                                    :value="item.value"
                                                    :disabled="item.disabled"
                                                >
                                                </el-option>
                                            </el-select>
                                        </el-form-item>
                                        <el-form>
                                            <el-button type="primary" @click="insertjs">确 定</el-button>
                                            <el-button @click="insertDialog = false">取 消</el-button>
                                        </el-form>
                                        </el-form>
                                    </el-dialog>
                                </el-container>
                        
                        <!-- 数据表格 -->
                        <el-table :data="jobseekerData"  >
                            <el-table-column prop="id" label="id" width="200">
                            </el-table-column>
                            <el-table-column prop="name" label="姓名" width="200">
                            </el-table-column>
                            <el-table-column label="图片" width="200">
                                <template slot-scope="scope">
                                    <img :src="scope.row.image" width="100px" height="70px">
                                </template>
                            </el-table-column>
                            <el-table-column prop="sex" label="性别" width="200">
                            </el-table-column>
                            <el-table-column prop="age" label="年龄" width="200">
                            </el-table-column>
                            <el-table-column prop="degree" label="学历" width="200">
                            </el-table-column>
                            <el-table-column prop="major" label="专业" width="200">
                            </el-table-column>
                            <el-table-column prop="jobName" label="应聘岗位" width="200">
                            </el-table-column>
                            <el-table-column label="审核状态" width="200">
                                <template slot-scope="scope">
                                    <el-switch
                                        v-model="scope.row.pass"
                                        active-color="#13ce66"
                                        inactive-color="#ff4949"
                                        active-text="通过"
                                        inactive-text="未通过"
                                        active-value="yes"
                                        inactive-value="no"
                                        @change="Audit(scope.row)"
                                        >
                                    </el-switch>
                                </template>
                            </el-table-column>
                            <el-table-column fixed="right" label="操作" width="200">
                                <template slot-scope="scope">
                                    <el-button type="primary" @click="updatedialog(scope.row)" icon="el-icon-edit" round size="small">编辑</el-button>
                                    <el-button type="danger" @click="deletejs(scope.row.id)" icon="el-icon-delete-solid" round size="small">删除</el-button>
                                </template>
                            </el-table-column>
                        </el-table>
                        <!-- 更新表单 -->
                        <el-dialog title="编辑简历" :visible.sync="dialogFormVisible">
                            <el-form :model="update" >
                                        <el-form-item label="名称" >
                                            <el-input v-model="update.name" ></el-input>
                                        </el-form-item>
                                        <el-form-item prop="image" label="上传图片" v-model="update.image">
                                            <!-- 图片上传 -->
                                             <el-upload
                                                name = "file"
                                                :action="'http://localhost:8080/jobseekers/upload'"
                                                list-type="picture-card"
                                                limit="1"
                                                :on-exceed="limitError"
                                                :on-success="handleSuccess"
                                                :on-error="imgError"
                                            >
                                                <i class="el-icon-plus"></i>
                                            </el-upload>

                                        </el-form-item>
                                        <el-form-item label="性别">
                                            <el-select v-model="update.sex" placeholder="请选择性别">
                                                <el-option label="男" value="男"></el-option>
                                                <el-option label="女" value="女"></el-option>
                                            </el-select>
                                        </el-form-item>
                                        <el-form-item label="年龄" :rules="[{ required: true, message: '年龄不能为空'},{ type: 'number', message: '年龄必须为数字值'}]">
                                            <el-input v-model.number="update.age"></el-input>
                                        </el-form-item>
                                        <el-form-item label="学历">
                                            <el-select v-model="update.degree" placeholder="请选择学历">
                                                <el-option label="大专" value="大专"></el-option>
                                                <el-option label="本科" value="本科"></el-option>
                                                <el-option label="硕士" value="硕士"></el-option>
                                                <el-option label="博士" value="博士"></el-option>
                                            </el-select>
                                        </el-form-item>
                                        <el-form-item label="应聘岗位" >
                                            <el-select v-model="update.jobId" placeholder="请选择岗位">
                                                <el-option
                                                    v-for="item in jobs"
                                                    :key="item.key"
                                                    :label="item.label"
                                                    :value="item.value"
                                                    :disabled="item.disabled"
                                                >
                                                </el-option>
                                            </el-select>
                                        </el-form-item>
                                        <el-form>
                                            <el-button type="primary" @click="updatejs">确 定</el-button>
                                            <el-button @click="dialogFormVisible = false">取 消</el-button>
                                        </el-form>
                                        </el-form>
                                    </el-dialog>
            </el-main>
        </el-container>
        </el-container>
    </div>
</body>
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
                    sex:null,
                    degree:null,
                    major:null,
                    jobId:null,
                    jobName:null,
                },
                delete:{
                    id:null
                },
                update:{
                    id:null,
                    name:null,
                    sex:null,
                    degree:null,
                    major:null,
                    image:null,
                },
                insert:{
                    id:null,
                    name:null,
                    sex:null,
                    degree:null,
                    major:null,
                    image:null,
                },
                jobs:[],
                jobseekerData: [],
                searchData:[],
                //更新对话框是否显示
                dialogFormVisible: false,
                //新增对话框
                insertDialog: false,
                //图片url
                imageUrl:'',
                //按钮
                value1:false
            }
        },
        methods: {
            searchjs(){
                //封装请求体
                const requestBody = {
                    ...this.search,
                }
                //axios异步请求向服务器发送post请求
                axios.post("http://localhost:8080/jobseekers/search",requestBody).then((result)=>{
                    this.jobseekerData = result.data.data;
                }).catch(error => {  
                // 请求失败时处理错误  
                console.error('查询失败:', error);  
                // 可以在这里设置this.result为错误消息或null  
                this.result = null;  
                });
            },
            //删除方法
            deletejs(id){
                const url = `http://localhost:8080/jobseekers/${id}`;
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
            getUpdateImage(){
                this.update.image = this.imageUrl
            },
            updatedialog(row){
                this.update.id = row.id;
                this.update.name = row.name;
                this.update.sex = row.sex;
                this.update.age = row.age;
                this.update.degree = row.degree;
                this.update.major = row.major;
                this.update.jobId =row.jobId;
                this.dialogFormVisible = true;
            },
            updatejs(){
                this.getUpdateImage();
                const requestBody = {
                    ...this.update,
                }
                axios.put("http://localhost:8080/jobseekers",requestBody).then((result)=>{
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
                this.dialogFormVisible = false;
                this.reload();
            },
            //新增方法
            getInsertImage(){
                this.insert.image = this.imageUrl;
            },
            insertdialog(){
                this.insertDialog = true;
            },
            insertjs(){
                this.getInsertImage();
                const requestBody = {
                    ...this.insert,
                }
                axios.post("http://localhost:8080/jobseekers",requestBody).then((result)=>{
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
                
            },
            //图片上传方法
            // 上传成功
            handleSuccess(res, file) {
                this.imageUrl = res.data
            },
            // 上传失败
            imgError(res) {
                this.$message({
                    type: "error",
                    message: "附件上传失败",
                });
            },
            // 上传数量超限
            limitError() {
                this.$message({
                    type: "error",
                    message: "图片仅可上传一张",
                });
            },
            //状态审核
            Audit(row){
                const requestBody = {
                    jobseekerId:row.id,
                    pass:row.pass
                }
                axios.post("http://localhost:8080/procedure/Audit",requestBody).then((result)=>{
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
                });
                this.reload();
            }
            
        },
        mounted(){
            //加载简历数据
            axios.get("http://localhost:8080/jobseekers/allJobseekers").then((result)=>{
                this.jobseekerData = result.data.data;
            });
            //加载岗位数据
            axios.get("http://localhost:8080/jobs/allJobs").then((result) => {  
                    this.jobs = result.data.data.map(job => ({  
                    value: job.id,  
                    label: job.name,  
                    disabled: job.num < 1, // 根据 num 的值设置 disabled  
                    }));  
                }).catch(error => {  
                    console.error('Error fetching jobs:', error);  
                });
            

        }

}
</script>
<style>
    .el-header {
    background-color: #b3d1ca;
    color: #333333;
    line-height: 60px;
    text-align:center;
    }

    .el-aside {
        color: #333333;
    }
    
</style>