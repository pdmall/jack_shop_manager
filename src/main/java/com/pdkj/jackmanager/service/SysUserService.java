package com.pdkj.jackmanager.service;

import com.pdkj.jackmanager.bean.SysUser;
import com.pdkj.jackmanager.dao.SysUserDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysUserService extends BaseService {

    public SysUser login(String username, String password) {
        return sysUserDao.login(username,password);
    }

    @Cacheable(value = "sysToken", key = "#p0")
    public SysUser getUserByToken(String token) {
        SysUser user = sysUserDao.getUserByToken(token);
        return user;
    }

    public List<SysUser> getSysUserList(Integer state) {
        return sysUserDao.getSysUserList(state);
    }
}
