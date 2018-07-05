package com.pdkj.jackmanager.controller;

import com.pdkj.jackmanager.bean.SysUser;
import com.pdkj.jackmanager.core.Result;
import com.pdkj.jackmanager.core.ResultGenerator;
import com.pdkj.jackmanager.util.sql.MySql;
import com.pdkj.jackmanager.util.sql.Pager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("shop")
public class ShopController extends BaseController{

    @GetMapping("getShopList")
    public Result getSysUserList(Pager page, Integer state){
        List<Map<String,Object>> users = shopService.getShopList(state,page);
        return ResultGenerator.genSuccessResult(users);
    }
}
