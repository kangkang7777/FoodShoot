package com.wfuhui.modules.bbs.dao;

import com.wfuhui.modules.bbs.entity.TopicEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

import org.apache.ibatis.annotations.Mapper;

/**
 * 主贴
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 * @date 2020-03-11 11:45:26
 */
@Mapper
public interface TopicDao extends BaseDao<TopicEntity> {
	
}
