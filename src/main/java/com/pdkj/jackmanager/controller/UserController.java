package com.pdkj.jackmanager.controller;


import com.pdkj.jackmanager.core.Result;
import com.pdkj.jackmanager.core.ResultGenerator;
import com.pdkj.jackmanager.dao.BaseDao;
import com.pdkj.jackmanager.util.sql.Pager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @GetMapping("getUserList")
    public Result getSysUserList(Pager page, Integer state,String key){
        List<Map<String,Object>> users = userService.getUserList(state,page,key);
        return ResultGenerator.genSuccessResult(users);
    }


}
