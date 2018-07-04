package com.pdkj.jackmanager.dao;


import com.pdkj.jackmanager.bean.SysUser;
import com.pdkj.jackmanager.util.Tools;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SysUserDao extends BaseDao{


    public SysUser login(String username, String pass) {
        pass = Tools.encryptPass(username, pass);
        String sql = "SELECT * from sys_user where username=? and password=?";
        RowMapper<SysUser> rowMap = new BeanPropertyRowMapper(SysUser.class);
        SysUser user = jdbcTemplate.queryForObject(sql, new Object[]{username, pass}, rowMap);
        user.setPassword(null);
        return user;
    }

    public SysUser getUserByToken(String token) {
        String sql = "SELECT * from sys_user where token=?";
        RowMapper<SysUser> rowMap = new BeanPropertyRowMapper(SysUser.class);
        List<SysUser> users = jdbcTemplate.query(sql, new Object[]{token}, rowMap);
        if (users.size() == 0) {
            return null;
        }
        return users.get(0);
    }

    public List<SysUser> getSysUserList(Integer state) {
        String sql = "SELECT * from sys_user where state=?";
        RowMapper<SysUser> rowMap = new BeanPropertyRowMapper(SysUser.class);
        List<SysUser> users = jdbcTemplate.query(sql, new Object[]{state}, rowMap);
        return users;
    }
}
