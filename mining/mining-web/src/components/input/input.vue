<template>
  <el-row>
    <el-col>
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="活动时间">
          <el-col :span="5">
            <el-date-picker
              type="date"
              placeholder="选择日期"
              v-model="form.date1"
              style="width: 100%;"
            ></el-date-picker>
          </el-col>

          <el-col :span="5">
            <el-form-item label="天数">
              <el-select v-model="form.region" placeholder="选择天数">
                <el-option label="1" value="shanghai"></el-option>
                <el-option label="2" value="beijing"></el-option>
                <el-option label="3" value="shanghai"></el-option>
                <el-option label="5" value="beijing"></el-option>
                <el-option label="7" value="shanghai"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="5">
            <el-form-item label="价格">
              <el-input v-model="form.name"></el-input>
            </el-form-item>
          </el-col>
        </el-form-item>
        
        <el-form-item>
          <el-button type="primary" @click="onSubmit">保存</el-button>
          <el-button>充值</el-button>
        </el-form-item>
      </el-form>
    </el-col>
  </el-row>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
      form: {
        name: "",
        region: "",
        date1: "",
        date2: "",
        delivery: false,
        type: [],
        resource: "",
        desc: ""
      }
    };
  },
  methods: {}
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hide-div {
  width: 100%;
  height: 20px;
}
</style>
