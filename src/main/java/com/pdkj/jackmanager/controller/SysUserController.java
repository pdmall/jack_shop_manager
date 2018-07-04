package com.pdkj.jackmanager.controller;


import com.pdkj.jackmanager.bean.SysUser;
import com.pdkj.jackmanager.core.Result;
import com.pdkj.jackmanager.core.ResultGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sysUser")
public class SysUserController extends BaseController{

    @PostMapping("login")
    public Result login(String username,String password){
        SysUser loginInfo = sysUserService.login(username, password);
        return ResultGenerator.genSuccessResult(loginInfo);
    }

    @GetMapping("getSysUserList")
    public Result getSysUserList(Integer state){
        List<SysUser> users = sysUserService.getSysUserList(state);
        return ResultGenerator.genSuccessResult(users);
    }

}
