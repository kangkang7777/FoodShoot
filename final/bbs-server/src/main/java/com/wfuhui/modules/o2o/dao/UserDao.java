package com.wfuhui.modules.o2o.dao;

import org.apache.ibatis.annotations.Mapper;

import com.wfuhui.modules.o2o.entity.UserEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

/**
 * 会员
 * 
 * @author lzl
 * @email 2803180149@qq.com
 * @date 2017-09-17 22:24:01
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {

	UserEntity queryByOpenid(String openid);
}
