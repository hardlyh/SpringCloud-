<template>
  <el-row>
     <el-col :span="4"><div class="hide-div"></div></el-col>
    <el-col :span="16">
      <div class="hello">
        <el-tabs v-model="activeName" @tab-click="handleClick">
          <el-tab-pane label="录入数据" name="first"><Input/></el-tab-pane>
          <el-tab-pane label="数据统计" name="second"><Chart/></el-tab-pane>
        </el-tabs>
      </div>
    </el-col>
     <el-col :span="4"><div></div></el-col>
  </el-row>
</template>

<script>
import Input from './input/input.vue'
import Chart from './chart/chart.vue'
export default {
  name: "index",
  data() {
    return {
      activeName: "second"
    };
  },
  components:{
    Input,
    Chart
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hide-div{
  width: 100%;
  height: 20px;
}
</style>
