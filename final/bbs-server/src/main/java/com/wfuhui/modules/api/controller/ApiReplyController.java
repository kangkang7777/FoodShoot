package com.wfuhui.modules.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.utils.R;
import com.wfuhui.modules.api.annotation.AuthIgnore;
import com.wfuhui.modules.bbs.entity.ReplyEntity;
import com.wfuhui.modules.bbs.service.ReplyService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/reply")
@Api("跟帖接口")
public class ApiReplyController {
	
	@Autowired
	private ReplyService replyService;
    
	@AuthIgnore
    @RequestMapping("/list")
	public R save(Integer topicId){
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("topicId", topicId);
		List<ReplyEntity> replyList = replyService.queryList(params);
		return R.ok().put("replyList", replyList);
	}
    
}
