package com.wfuhui.modules.api.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.utils.R;
import com.wfuhui.modules.api.annotation.AuthIgnore;
import com.wfuhui.modules.api.annotation.LoginUser;
import com.wfuhui.modules.bbs.entity.LikeEntity;
import com.wfuhui.modules.bbs.entity.ReplyEntity;
import com.wfuhui.modules.bbs.entity.TopicEntity;
import com.wfuhui.modules.bbs.service.LikeService;
import com.wfuhui.modules.bbs.service.ReplyService;
import com.wfuhui.modules.bbs.service.TopicService;
import com.wfuhui.modules.o2o.entity.UserEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/topic")
@Api("帖子接口")
public class ApiTopicController {
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private LikeService likeService;
	
	@Autowired
	private ReplyService replyService;
	
	@AuthIgnore
    @GetMapping("list")
    @ApiOperation(value = "帖子列表")
    public R list(@RequestParam Map<String, Object> params){
    	List<TopicEntity> topicList = topicService.queryList(params);
        return R.ok().put("topicList", topicList);
    }
	
	@GetMapping("mylist")
    @ApiOperation(value = "帖子列表")
    public R mylist(@RequestParam Map<String, Object> params, @LoginUser UserEntity user){
		params.put("userId", user.getId());
    	List<TopicEntity> topicList = topicService.queryList(params);
        return R.ok().put("topicList", topicList);
    }
    
    @RequestMapping("/save")
    @ApiOperation(value = "保存帖子")
	public R save(@RequestBody TopicEntity topic, @LoginUser UserEntity user){
    	topic.setMemberId(user.getId());
    	topic.setCreateTime(new Date());
		topicService.save(topic);
		
		return R.ok();
	}
    
    @RequestMapping("/detail")
    @ApiOperation(value = "帖子详情")
    public R detail(Integer id) {
    	TopicEntity topic = topicService.queryObject(id);
    	return R.ok().put("topic", topic);
    }
    
    
    @RequestMapping("/del")
    @ApiOperation(value = "帖子删除")
    public R del(Integer id) {
    	topicService.delete(id);;
    	return R.ok();
    }
    
    @RequestMapping("/isLike")
    @ApiOperation(value = "是否点赞")
	public R isLike(Integer topicId, @LoginUser UserEntity user){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("topicId", topicId);
    	map.put("userId", user.getId());
		int total = likeService.queryTotal(map);
		if(total > 0) {
			return R.ok();
		}
		return R.error();
	}
    
    @RequestMapping("/like")
    @ApiOperation(value = "点赞")
    public R like(Integer topicId, @LoginUser UserEntity user) {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("topicId", topicId);
    	params.put("userId", user.getId());
    	Integer total = likeService.queryTotal(params);
    	if(total > 0) {
    		return R.ok();
    	}
    	LikeEntity like = new LikeEntity();
    	like.setTopicId(topicId);
    	like.setCreateTime(new Date());
    	like.setMemberId(user.getId());
    	likeService.save(like);
    	return R.ok();
    }
    
    @RequestMapping("/unlike")
    @ApiOperation(value = "取消点赞")
    public R unlike(Integer topicId, @LoginUser UserEntity user) {
    	likeService.remove(topicId, user.getId());
    	return R.ok();
    }
    
    @RequestMapping("/reply")
    @ApiOperation(value = "回帖")
	public R save(@RequestBody ReplyEntity reply, @LoginUser UserEntity user){
    	reply.setMemberId(user.getId());
    	reply.setCreateTime(new Date());
		replyService.save(reply);
		
		return R.ok();
	}
}
