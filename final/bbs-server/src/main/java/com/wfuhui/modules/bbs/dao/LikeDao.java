package com.wfuhui.modules.bbs.dao;

import com.wfuhui.modules.bbs.entity.LikeEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 点赞
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 * @date 2020-03-11 11:45:26
 */
@Mapper
public interface LikeDao extends BaseDao<LikeEntity> {

	void remove(@Param("topicId") Integer topicId, @Param("userId") Long userId);
	
}
