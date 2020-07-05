package com.wfuhui.modules.bbs.dao;

import com.wfuhui.modules.bbs.entity.ReplyEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

import org.apache.ibatis.annotations.Mapper;

/**
 * 跟帖
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 * @date 2020-03-11 11:45:26
 */
@Mapper
public interface ReplyDao extends BaseDao<ReplyEntity> {
	
}
