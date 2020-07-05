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

import com.wfuhui.modules.bbs.entity.ReplyEntity;
import com.wfuhui.modules.bbs.service.ReplyService;
import com.wfuhui.common.utils.PageUtils;
import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;




/**
 * 跟帖
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 * @date 2020-03-11 11:45:26
 */
@RestController
@RequestMapping("reply")
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("reply:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ReplyEntity> replyList = replyService.queryList(query);
		int total = replyService.queryTotal(query);
		
		return R.ok().put("rows", replyList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("reply:info")
	public R info(@PathVariable("id") Integer id){
		ReplyEntity reply = replyService.queryObject(id);
		
		return R.ok().put("reply", reply);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("reply:save")
	public R save(@RequestBody ReplyEntity reply){
		replyService.save(reply);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("reply:update")
	public R update(@RequestBody ReplyEntity reply){
		replyService.update(reply);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("reply:delete")
	public R delete(@RequestBody Integer[] ids){
		replyService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
