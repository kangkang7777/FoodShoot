package com.wfuhui.modules.o2o.service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.o2o.entity.UserEntity;

/**
 * 会员
 * 
 * @author lzl
 * @email 2803180149@qq.com
 * @date 2017-09-17 22:24:01
 */
public interface UserService {
	
	UserEntity queryObject(Long id);
	
	List<UserEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserEntity user);
	
	void update(UserEntity user);
	
	void delete(Long id);
	
	void deleteBatch(Integer[] ids);

	UserEntity queryByOpenid(String openid);
}
