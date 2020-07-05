package com.wfuhui.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 字典
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 * @date 2019-03-11 17:48:00
 */
public class SysDictEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//key
	private String key;
	//值
	private String value;
	//类型
	private String type;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * 获取：key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * 设置：值
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 获取：值
	 */
	public String getValue() {
		return value;
	}
	/**
	 * 设置：类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public String getType() {
		return type;
	}
}
