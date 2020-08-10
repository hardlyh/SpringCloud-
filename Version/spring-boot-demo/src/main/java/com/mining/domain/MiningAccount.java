package com.mining.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.mining.utils.TimeUtil;

/**
 * <p>
 * 挖矿用户表
 * </p>
 *
 * @author liyh
 * @since 2020-08-06
 */
public class MiningAccount extends Model<MiningAccount> {

	private static final long serialVersionUID = 1L;

	/**
	 * 会员ID
	 */
	@TableId(value = "member_id", type = IdType.AUTO)
	private Integer memberId;

	/**
	 * 账号/手机号
	 */
	private String staffNumber;

	/**
	 * 工作人员姓名
	 */
	private String staffName;

	/**
	 * 登录密码
	 */
	private String staffPassword;

	/**
	 * 证件种类
	 */
	private Integer identityCardType;

	/**
	 * 身份证号
	 */
	private String identityCardId;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 账号有效状态
	 */
	private Integer status;

	/**
	 * 备注
	 */
	private String memberNote;

	/**
	 * 注册者
	 */
	private String memberRegisterName;

	/**
	 * 注册日时
	 */
	private String memberRegisterDatetime = TimeUtil.getNowDateStr(1);;

	/**
	 * 更新者
	 */
	private String memberUpdateName;

	/**
	 * 更新日时
	 */
	private String memberUpdateDatetime = TimeUtil.getNowDateStr(1);;

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffPassword() {
		return staffPassword;
	}

	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}

	public Integer getIdentityCardType() {
		return identityCardType;
	}

	public void setIdentityCardType(Integer identityCardType) {
		this.identityCardType = identityCardType;
	}

	public String getIdentityCardId() {
		return identityCardId;
	}

	public void setIdentityCardId(String identityCardId) {
		this.identityCardId = identityCardId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMemberNote() {
		return memberNote;
	}

	public void setMemberNote(String memberNote) {
		this.memberNote = memberNote;
	}

	public String getMemberRegisterName() {
		return memberRegisterName;
	}

	public void setMemberRegisterName(String memberRegisterName) {
		this.memberRegisterName = memberRegisterName;
	}

	public String getMemberRegisterDatetime() {
		return memberRegisterDatetime;
	}

	public void setMemberRegisterDatetime(String memberRegisterDatetime) {
		this.memberRegisterDatetime = memberRegisterDatetime;
	}

	public String getMemberUpdateName() {
		return memberUpdateName;
	}

	public void setMemberUpdateName(String memberUpdateName) {
		this.memberUpdateName = memberUpdateName;
	}

	public String getMemberUpdateDatetime() {
		return memberUpdateDatetime;
	}

	public void setMemberUpdateDatetime(String memberUpdateDatetime) {
		this.memberUpdateDatetime = memberUpdateDatetime;
	}

	@Override
	protected Serializable pkVal() {
		return this.memberId;
	}

	@Override
	public String toString() {
		return "MiningAccount{" + "memberId=" + memberId + ", staffNumber=" + staffNumber + ", staffName=" + staffName
				+ ", staffPassword=" + staffPassword + ", identityCardType=" + identityCardType + ", identityCardId="
				+ identityCardId + ", sort=" + sort + ", status=" + status + ", memberNote=" + memberNote
				+ ", memberRegisterName=" + memberRegisterName + ", memberRegisterDatetime=" + memberRegisterDatetime
				+ ", memberUpdateName=" + memberUpdateName + ", memberUpdateDatetime=" + memberUpdateDatetime + "}";
	}
}
