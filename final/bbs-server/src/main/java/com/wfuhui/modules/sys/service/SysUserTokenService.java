package com.wfuhui.modules.sys.service;

import com.wfuhui.modules.sys.entity.SysUserTokenEntity;
import com.wfuhui.common.utils.R;

/**
 * 用户Token
 * 
 * @author lzl
 * @email 2803180149@qq.com
 * @date 2017-03-23 15:22:07
 */
public interface SysUserTokenService {

	SysUserTokenEntity queryByUserId(Long userId);

	SysUserTokenEntity queryByToken(String token);
	
	void save(SysUserTokenEntity token);
	
	void update(SysUserTokenEntity token);

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	R createToken(long userId);

}
