package com.wfuhui.modules.bbs.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.modules.bbs.entity.LikeEntity;
import com.wfuhui.modules.bbs.service.LikeService;
import com.wfuhui.common.utils.PageUtils;
import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;




/**
 * 点赞
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 * @date 2020-03-11 11:45:26
 */
@RestController
@RequestMapping("like")
public class LikeController {
	@Autowired
	private LikeService likeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("like:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<LikeEntity> likeList = likeService.queryList(query);
		int total = likeService.queryTotal(query);
		
		return R.ok().put("rows", likeList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("like:info")
	public R info(@PathVariable("id") Integer id){
		LikeEntity like = likeService.queryObject(id);
		
		return R.ok().put("like", like);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("like:save")
	public R save(@RequestBody LikeEntity like){
		likeService.save(like);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("like:update")
	public R update(@RequestBody LikeEntity like){
		likeService.update(like);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("like:delete")
	public R delete(@RequestBody Integer[] ids){
		likeService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
