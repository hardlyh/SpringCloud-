<template>
  <el-row>
    <el-col>
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="活动时间">
          <el-col :span="5">
            <el-date-picker
              type="date"
              placeholder="选择日期"
              v-model="form.date"
              format="yyyy-MM-dd"
              value-format="yyyy-MM-dd"
              style="width: 100%;"
            ></el-date-picker>
          </el-col>

          <el-col :span="5">
            <el-form-item label="天数">
              <el-select v-model="form.dayNumber" placeholder="选择天数">
                <el-option label="1" value="1"></el-option>
                <el-option label="2" value="2"></el-option>
                <el-option label="3" value="3"></el-option>
                <el-option label="5" value="5"></el-option>
                <el-option label="7" value="7"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="5">
            <el-form-item label="价格">
              <el-input v-model="form.price"></el-input>
            </el-form-item>
          </el-col>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="onSubmit">保存</el-button>
          <el-button @click="reset">重置</el-button>
        </el-form-item>
      </el-form>
    </el-col>


    <el-col>


    </el-col>
  </el-row>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
      form: {
        dayNumber: 1,
        price: "",
        date: this.moment().format("YYYY-MM-DD"),
      },
    };
  },
  methods: {
    reset() {
      this.form.dayNumber = "";
      this.form.price = "";
      this.form.date = "";
    },
    onSubmit() {
      if (this.form.dayNumber && this.form.price && this.form.date) {
        this.apis.savePayInfo(this.form).then((res) => {
          console.log(res);
          this.$message({
            message: "保存成功",
            type: "success",
          });
        });
      } else {
        this.$message({
          message: "请检查数据完整性",
        });
      }
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hide-div {
  width: 100%;
  height: 20px;
}
</style>
