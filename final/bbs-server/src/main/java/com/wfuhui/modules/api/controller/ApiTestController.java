package com.wfuhui.modules.api.controller;


import com.wfuhui.common.utils.R;
import com.wfuhui.modules.api.annotation.AuthIgnore;
import com.wfuhui.modules.api.annotation.LoginUser;
import com.wfuhui.modules.o2o.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API测试接口
 *
 * @author lzl
 * @email 2803180149@qq.com
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("/api")
@Api("测试接口")
public class ApiTestController {

    /**
     * 获取用户信息
     */
    @GetMapping("userInfo")
    @ApiOperation(value = "获取用户信息")
    @ApiImplicitParam(paramType = "header", name = "token", value = "token", required = true)
    public R userInfo(@LoginUser UserEntity user){
        return R.ok().put("user", user);
    }

    /**
     * 忽略Token验证测试
     */
    @AuthIgnore
    @GetMapping("notToken")
    @ApiOperation(value = "忽略Token验证测试")
    public R notToken(){
        return R.ok().put("msg", "无需token也能访问。。。");
    }
}
