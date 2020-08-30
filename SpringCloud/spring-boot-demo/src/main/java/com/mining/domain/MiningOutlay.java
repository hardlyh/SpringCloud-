package com.mining.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.mining.utils.TimeUtil;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 挖矿支出
 * </p>
 *
 * @author liyh
 * @since 2020-08-06
 */
public class MiningOutlay extends Model<MiningOutlay> {

    private static final long serialVersionUID=1L;

    /**
     * 表Id
     */
    @TableId(value = "outlay_id", type = IdType.AUTO)
    private Integer outlayId;

    /**
     * 购买时间
     */
    private String outlayDay;

    /**
     * 天数
     */
    private Integer dayNumber;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 总金额
     */
    private Integer totalAmt;

    /**
     * 利润
     */
    private Integer profit;

    /**
     * 利率
     */
    private Integer rete;

    /**
     * 到期日
     */
    private String lineNumber;

    /**
     * 登录日时
     */
    private String registerDatetime = TimeUtil.getNowDateStr(1);

    /**
     * 更新者
     */
    private String updateName;

    /**
     * 更新日时
     */
    private String updateDatetime = TimeUtil.getNowDateStr(1);


    public Integer getOutlayId() {
        return outlayId;
    }

    public void setOutlayId(Integer outlayId) {
        this.outlayId = outlayId;
    }

    public String getOutlayDay() {
        return outlayDay;
    }

    public void setOutlayDay(String outlayDay) {
        this.outlayDay = outlayDay;
    }

    public Integer getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(Integer dayNumber) {
        this.dayNumber = dayNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(Integer totalAmt) {
        this.totalAmt = totalAmt;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public Integer getRete() {
        return rete;
    }

    public void setRete(Integer rete) {
        this.rete = rete;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getRegisterDatetime() {
        return registerDatetime;
    }

    public void setRegisterDatetime(String registerDatetime) {
        this.registerDatetime = registerDatetime;
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
        return this.outlayId;
    }

    @Override
    public String toString() {
        return "MiningOutlay{" +
        "outlayId=" + outlayId +
        ", outlayDay=" + outlayDay +
        ", dayNumber=" + dayNumber +
        ", price=" + price +
        ", totalAmt=" + totalAmt +
        ", profit=" + profit +
        ", rete=" + rete +
        ", lineNumber=" + lineNumber +
        ", registerDatetime=" + registerDatetime +
        ", updateName=" + updateName +
        ", updateDatetime=" + updateDatetime +
        "}";
    }
}
