package com.pdkj.jackmanager.service;

import com.pdkj.jackmanager.bean.SysUser;
import com.pdkj.jackmanager.dao.SysUserDao;
import com.pdkj.jackmanager.util.sql.Pager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


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

    public List<Map<String,Object>> getSysUserList(Integer state, Pager page, String key) {
        return sysUserDao.getSysUserList(state,page,key);
    }
}
