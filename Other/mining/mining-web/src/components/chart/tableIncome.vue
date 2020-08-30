<template>
  <div>
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
      <el-form-item label="活动时间">
        <el-col :span="11">
          <el-date-picker
            type="date"
            placeholder="选择日期"
            v-model="formInline.startTime"
            style="width: 100%;"
          ></el-date-picker>
        </el-col>
        <el-col class="line" :span="1">-</el-col>
        <el-col :span="11">
          <el-date-picker
            type="date"
            placeholder="选择日期"
            v-model="formInline.endTime"
            style="width: 100%;"
          ></el-date-picker>
        </el-col>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="inquirIncome">查询</el-button>
      </el-form-item>
    </el-form>

    <el-table :data="countInfo" border style="width: 100%">
      <el-table-column prop="price" :formatter="amountFormat" label="收入(本金)" align="center"></el-table-column>
      <el-table-column prop="profit" :formatter="amountFormat" label="总利润" align="center"></el-table-column>
      <el-table-column prop="rete" label="利率(%)" align="center"></el-table-column>
      <el-table-column prop="totalAmt" :formatter="amountFormat" label="总金额" align="center"></el-table-column>
      <el-table-column prop="lineNumber" label="总笔数" align="center"></el-table-column>
    </el-table>

    <el-table :data="groupList" border style="width: 100%">
      <el-table-column prop="lineNumber" label="到期时间" align="center"></el-table-column>
      <el-table-column prop="price" :formatter="amountFormat" label="收入(本金)" align="center"></el-table-column>
      <el-table-column prop="profit" :formatter="amountFormat" label="总利润" align="center"></el-table-column>
      <el-table-column prop="rete" label="利率(%)" align="center"></el-table-column>
      <el-table-column prop="totalAmt" :formatter="amountFormat" label="总金额" align="center"></el-table-column>
      <el-table-column prop="outlayDay" label="总笔数" align="center"></el-table-column>
      <el-table-column fixed="right" label="操作" width="120">
        <template slot-scope="scope">
          <el-button @click="cliRow(scope.row)" type="text">明细</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="收货地址" :visible.sync="dialogTableVisible">
      <el-tag type="success">本金:{{dialogTag.pay2}}</el-tag>&nbsp;
      <el-tag type="danger">总利润:{{dialogTag.profit}}</el-tag>
      <el-table :data="detailList">
        <el-table-column prop="outlayDay" label="购买时间" align="center"></el-table-column>
        <el-table-column prop="lineNumber" label="到期时间" align="center"></el-table-column>
        <el-table-column prop="price" :formatter="amountFormat" label="总额(本金)" align="center"></el-table-column>
        <el-table-column prop="profit" :formatter="amountFormat" label="总利润" align="center"></el-table-column>
        <el-table-column prop="totalAmt" :formatter="amountFormat" label="总金额" align="center"></el-table-column>
        <el-table-column prop="dayNumber" label="购买天数" align="center"></el-table-column>
        <el-table-column prop="rete" label="利率(%)" align="center"></el-table-column>
      </el-table>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "tableIncome",
  data() {
    return {
      dialogTag:{},
      dialogTableVisible: false,
      countInfo: [],
      groupList: [],
      detailList: [],
      formInline: {
        startTime: this.moment().add("days", 1).format("YYYY-MM-DD"),
        endTime: this.moment().add("days", 6).format("YYYY-MM-DD"),
      },
      tableData: [],
    };
  },
  methods: {
    amountFormat(row, col, cellValue) {
      return cellValue / 100;
    },
    cliRow(rows) {
      this.detailList = [];
      this.dialogTag= {};
      let dateTime = rows.lineNumber;
      this.dialogTag.pay2 = rows.price / 100;
      this.dialogTag.profit = rows.profit / 100;
      let data = {
        dateTime: dateTime,
      };
      this.apis.getIncomeInfoDetail(data).then((response) => {
        this.detailList = response;
        this.dialogTableVisible = true;
      });
    },
    inquirIncome() {
      this.countInfo = [];
      this.groupList = [];
      this.apis.getIncomeInfo(this.formInline).then((response) => {
        this.countInfo = response.countInfo;
        this.groupList = response.groupList;
      });
    },
  },
  created: function () {
    this.inquirIncome();
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
