package com.mining.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 人数记录表
 * </p>
 *
 * @author liyh
 * @since 2020-08-23
 */
public class MiningPeopleCount extends Model<MiningPeopleCount> {

    private static final long serialVersionUID=1L;

    /**
     * 表id
     */
    @TableId(value = "count_id", type = IdType.AUTO)
    private Long countId;

    /**
     * 机构
     */
    private String groupId;

    /**
     * 日期
     */
    private String countDay;

    /**
     * 总人数
     */
    private String totalPeople;

    /**
     * 在线人数
     */
    private String onlinePeople;

    /**
     * 记录日时
     */
    private String registerDatetime;

    public MiningPeopleCount() {
		super();
	}

	/**
     * 备注
     */
    private String note;


    public Long getCountId() {
        return countId;
    }

    public void setCountId(Long countId) {
        this.countId = countId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getCountDay() {
        return countDay;
    }

    public void setCountDay(String countDay) {
        this.countDay = countDay;
    }

    public String getTotalPeople() {
        return totalPeople;
    }

    public void setTotalPeople(String totalPeople) {
        this.totalPeople = totalPeople;
    }

    public String getOnlinePeople() {
        return onlinePeople;
    }

    public void setOnlinePeople(String onlinePeople) {
        this.onlinePeople = onlinePeople;
    }

    public String getRegisterDatetime() {
        return registerDatetime;
    }

    public void setRegisterDatetime(String registerDatetime) {
        this.registerDatetime = registerDatetime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    protected Serializable pkVal() {
        return this.countId;
    }

    @Override
    public String toString() {
        return "MiningPeopleCount{" +
        "countId=" + countId +
        ", groupId=" + groupId +
        ", countDay=" + countDay +
        ", totalPeople=" + totalPeople +
        ", onlinePeople=" + onlinePeople +
        ", registerDatetime=" + registerDatetime +
        ", note=" + note +
        "}";
    }

	public MiningPeopleCount(Long countId, String groupId, String countDay, String totalPeople, String onlinePeople,
			String registerDatetime, String note) {
		super();
		this.countId = countId;
		this.groupId = groupId;
		this.countDay = countDay;
		this.totalPeople = totalPeople;
		this.onlinePeople = onlinePeople;
		this.registerDatetime = registerDatetime;
		this.note = note;
	}
    
    
}
