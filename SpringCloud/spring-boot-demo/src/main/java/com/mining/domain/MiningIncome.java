package com.mining.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.mining.utils.TimeUtil;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 挖矿收入表
 * </p>
 *
 * @author liyh
 * @since 2020-08-06
 */
public class MiningIncome extends Model<MiningIncome> {

    private static final long serialVersionUID=1L;

    /**
     * 表ID
     */
    @TableId(value = "income_id", type = IdType.AUTO)
    private Integer incomeId;

    /**
     * 时间
     */
    private String incomeDay;

    /**
     * 本金(总)
     */
    private Integer principal;

    /**
     * 利润(总)
     */
    private Integer profit;

    /**
     * 利润率(总)
     */
    private Integer profitMargin;

    /**
     * 笔数(总)
     */
    private Integer count;

    /**
     * 总额
     */
    private Integer totalAmt;

    /**
     * 订单生成者
     */
    private String createName;

    /**
     * 订单生成日时
     */
    private String createDatetime = TimeUtil.getNowDateStr(1);

    /**
     * 订单更新者
     */
    private String updateName = TimeUtil.getNowDateStr(1);

    /**
     * 订单更新日时
     */
    private String updateDatetime;


    public Integer getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Integer incomeId) {
        this.incomeId = incomeId;
    }

    public String getIncomeDay() {
        return incomeDay;
    }

    public void setIncomeDay(String incomeDay) {
        this.incomeDay = incomeDay;
    }

    public Integer getPrincipal() {
        return principal;
    }

    public void setPrincipal(Integer principal) {
        this.principal = principal;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public Integer getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(Integer profitMargin) {
        this.profitMargin = profitMargin;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(Integer totalAmt) {
        this.totalAmt = totalAmt;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    @Override
    protected Serializable pkVal() {
        return this.incomeId;
    }

    @Override
    public String toString() {
        return "MiningIncome{" +
        "incomeId=" + incomeId +
        ", incomeDay=" + incomeDay +
        ", principal=" + principal +
        ", profit=" + profit +
        ", profitMargin=" + profitMargin +
        ", count=" + count +
        ", totalAmt=" + totalAmt +
        ", createName=" + createName +
        ", createDatetime=" + createDatetime +
        ", updateName=" + updateName +
        ", updateDatetime=" + updateDatetime +
        "}";
    }
}
