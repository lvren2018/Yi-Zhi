<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="作品名" prop="entries">
        <el-input
          v-model="queryParams.entries"
          placeholder="请输入作品名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['admin:entries:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['admin:entries:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['admin:entries:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['admin:entries:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="entriesList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="作品名" align="center" prop="entries" />
      <el-table-column label="主键" align="center" prop="entriesId" />
      <el-table-column label="联系方式" align="center" prop="phone" />
      <el-table-column label="实时平均分" align="center" prop="score" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['admin:entries:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['admin:entries:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改作品管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="作品名" prop="entries">
          <el-input v-model="form.entries" placeholder="请输入作品名" />
        </el-form-item>
        <el-form-item label="联系方式" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入联系方式" />
        </el-form-item>
        <el-form-item label="实时平均分" prop="score">
          <el-input v-model="form.score" placeholder="请输入实时平均分" />
        </el-form-item>
        <el-form-item label="账号ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入账号ID" />
        </el-form-item>
        <el-divider content-position="center">账户管理信息</el-divider>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddDevUser">添加</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteDevUser">删除</el-button>
          </el-col>
        </el-row>
        <el-table :data="devUserList" :row-class-name="rowDevUserIndex" @selection-change="handleDevUserSelectionChange" ref="devUser">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50"/>
          <el-table-column label="姓名" prop="name" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.name" placeholder="请输入姓名" />
            </template>
          </el-table-column>
          <el-table-column label="身份" prop="identity" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.identity" placeholder="请输入身份" />
            </template>
          </el-table-column>
          <el-table-column label="学校" prop="school" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.school" placeholder="请输入学校" />
            </template>
          </el-table-column>
          <el-table-column label="账号名" prop="userName" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.userName" placeholder="请输入账号名" />
            </template>
          </el-table-column>
          <el-table-column label="报名分组" prop="groupName" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.groupName" placeholder="请输入报名分组" />
            </template>
          </el-table-column>
        </el-table>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listEntries, getEntries, delEntries, addEntries, updateEntries } from "@/api/admin/entries";

export default {
  name: "Entries",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 子表选中数据
      checkedDevUser: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 作品管理表格数据
      entriesList: [],
      // 账户管理表格数据
      devUserList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        entries: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        entries: [
          { required: true, message: "作品名不能为空", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "账号ID不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询作品管理列表 */
    getList() {
      this.loading = true;
      listEntries(this.queryParams).then(response => {
        this.entriesList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        entries: null,
        entriesId: null,
        phone: null,
        score: null,
        userId: null,
        createTime: null
      };
      this.devUserList = [];
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.entriesId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加作品管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const entriesId = row.entriesId || this.ids
      getEntries(entriesId).then(response => {
        this.form = response.data;
        this.devUserList = response.data.devUserList;
        this.open = true;
        this.title = "修改作品管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.devUserList = this.devUserList;
          if (this.form.entriesId != null) {
            updateEntries(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addEntries(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const entriesIds = row.entriesId || this.ids;
      this.$modal.confirm('是否确认删除作品管理编号为"' + entriesIds + '"的数据项？').then(function() {
        return delEntries(entriesIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
	/** 账户管理序号 */
    rowDevUserIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** 账户管理添加按钮操作 */
    handleAddDevUser() {
      let obj = {};
      obj.name = "";
      obj.identity = "";
      obj.school = "";
      obj.userName = "";
      obj.groupName = "";
      this.devUserList.push(obj);
    },
    /** 账户管理删除按钮操作 */
    handleDeleteDevUser() {
      if (this.checkedDevUser.length == 0) {
        this.$modal.msgError("请先选择要删除的账户管理数据");
      } else {
        const devUserList = this.devUserList;
        const checkedDevUser = this.checkedDevUser;
        this.devUserList = devUserList.filter(function(item) {
          return checkedDevUser.indexOf(item.index) == -1
        });
      }
    },
    /** 复选框选中数据 */
    handleDevUserSelectionChange(selection) {
      this.checkedDevUser = selection.map(item => item.index)
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('admin/entries/export', {
        ...this.queryParams
      }, `entries_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
