package com.wfuhui.modules.sys.service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.sys.entity.SysDictEntity;

/**
 * 字典
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 * @date 2019-03-11 17:48:00
 */
public interface SysDictService {
	
	SysDictEntity queryObject(Integer id);
	
	List<SysDictEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysDictEntity sysDict);
	
	void update(SysDictEntity sysDict);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
