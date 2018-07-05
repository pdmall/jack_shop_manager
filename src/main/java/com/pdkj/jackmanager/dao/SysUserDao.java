package com.pdkj.jackmanager.dao;


import com.pdkj.jackmanager.bean.SysUser;
import com.pdkj.jackmanager.core.CustomException;
import com.pdkj.jackmanager.util.Tools;
import com.pdkj.jackmanager.util.sql.MySql;
import com.pdkj.jackmanager.util.sql.Pager;
import com.pdkj.jackmanager.util.sql.SQLTools;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SysUserDao extends BaseDao{


    public SysUser login(String username, String pass) {
        pass = Tools.encryptPass(username, pass);
        String sql = "SELECT * from sys_user where username=?";
        RowMapper<SysUser> rowMap = new BeanPropertyRowMapper(SysUser.class);
        List<SysUser> users = jdbcTemplate.query(sql, new Object[]{username}, rowMap);
        if(users.size()==0||!users.get(0).getPassword().equals(pass)){
            throw new CustomException("用户名或密码错误");
        }
        users.get(0).setPassword(null);
        return users.get(0);
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

    public List<Map<String,Object>> getSysUserList(Integer state, Pager page, String key) {
        MySql sql = new MySql("SELECT s.*,r.name role_name from sys_user s,sys_role r where state=? and r.id = s.role_id");
        sql.addValue(state);
        String keys = SQLTools.FuzzyKey(key);
        sql.notNullAppend("and (s.name like ? or s.username like ? or s.phone like ?) ",keys,keys,keys);
        sql.limit(page);
        List<Map<String,Object>> users = jdbcTemplate.queryForList(sql.toString(),sql.getValues());
        for(int i=0; i<users.size(); i++){
            users.get(i).remove("password");
        }
        return users;
    }
}
