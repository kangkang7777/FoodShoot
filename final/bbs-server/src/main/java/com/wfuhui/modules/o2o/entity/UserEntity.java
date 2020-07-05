package com.wfuhui.modules.o2o.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员
 * 
 * @author lzl
 * @email 2803180149@qq.com
 * @date 2017-09-17 22:24:01
 */
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Long id;
	// 微信openid
	private String openid;
	// 昵称
	private String nickname;
	// 头像
	private String avatarUrl;

	// 性别
	private String gender;

	// 创建时间
	private Date createTime;

	private String realName;

	private String mobile;
	
	private String userNo;
	
	private String schoolName;
	
	private String password;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置：微信openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * 获取：微信openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * 设置：昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * 获取：昵称
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * 设置：头像
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	/**
	 * 获取：头像
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
