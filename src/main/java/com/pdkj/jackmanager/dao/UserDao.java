package com.pdkj.jackmanager.dao;

import com.pdkj.jackmanager.bean.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDao extends BaseDao {
    public Map<String, Object> getUser(Long id){
        String sql ="Select id,`name` from user where id = ?";
        return jdbcTemplate.queryForMap(sql,id);
    }

    public void update(User oldUser) {
        String sql = "";
        jdbcTemplate.update(sql);
    }

}
