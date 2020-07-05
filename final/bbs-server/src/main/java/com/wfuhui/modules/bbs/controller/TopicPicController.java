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

import com.wfuhui.modules.bbs.entity.TopicPicEntity;
import com.wfuhui.modules.bbs.service.TopicPicService;
import com.wfuhui.common.utils.PageUtils;
import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;




/**
 * 主贴图片
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 * @date 2020-03-11 11:45:26
 */
@RestController
@RequestMapping("topicpic")
public class TopicPicController {
	@Autowired
	private TopicPicService topicPicService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("topicpic:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TopicPicEntity> topicPicList = topicPicService.queryList(query);
		int total = topicPicService.queryTotal(query);
		
		return R.ok().put("rows", topicPicList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("topicpic:info")
	public R info(@PathVariable("id") Integer id){
		TopicPicEntity topicPic = topicPicService.queryObject(id);
		
		return R.ok().put("topicPic", topicPic);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("topicpic:save")
	public R save(@RequestBody TopicPicEntity topicPic){
		topicPicService.save(topicPic);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("topicpic:update")
	public R update(@RequestBody TopicPicEntity topicPic){
		topicPicService.update(topicPic);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("topicpic:delete")
	public R delete(@RequestBody Integer[] ids){
		topicPicService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
