package com.pdkj.jackmanager.controller;

import com.pdkj.jackmanager.bean.SysUser;
import com.pdkj.jackmanager.service.BannerService;
import com.pdkj.jackmanager.service.ShopService;
import com.pdkj.jackmanager.service.SysUserService;
import com.pdkj.jackmanager.service.UserService;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;

public class BaseController {

    @Resource
    SysUserService sysUserService;

    @Resource
    ShopService shopService;

    @Resource
    UserService userService;


    @Resource
    public BannerService bannerService;

    public SysUser getUser(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return (SysUser) requestAttributes.getAttribute("user", 0);
    }
}
