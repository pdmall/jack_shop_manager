package com.pdkj.jackmanager.dao;

import com.pdkj.jackmanager.configurer.AliYunOSS;
import com.pdkj.jackmanager.util.sql.MySql;
import com.pdkj.jackmanager.util.sql.Pager;
import com.pdkj.jackmanager.util.sql.SQLTools;
import com.pdkj.jackmanager.util.sql.SqlInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.pdkj.jackmanager.bean.User;
import java.util.Map;

@Repository
public class UserDao extends BaseDao {

    public List<Map<String,Object>> getUserList(Integer state, Pager page, String key) {
        MySql sql = new MySql("SELECT s.*,r.name role_name from user s,role r where state=? and r.id = s.role_id");
        sql.addValue(state);
        String keys = SQLTools.FuzzyKey(key);
        sql.notNullAppend("and (s.name like ? or s.username like ? or s.phone like ?) ",keys,keys,keys);
        sql.limit(page);
        List<Map<String,Object>> users = jdbcTemplate.queryForList(sql.toString(), sql.getValues());
        for(int i=0; i<users.size(); i++){
            users.get(i).remove("password");
        }
        return users;
    }
    public Map<String, Object> getUser(Long id){
        String sql ="Select id,`name` from user where id = ?";
        return jdbcTemplate.queryForMap(sql,id);
    }

    public void update  (User oldUser) {
        SqlInfo sql  = SQLTools.getUpdateById(oldUser,"user",oldUser.getId());
        jdbcTemplate.update(sql.getSql(),sql.getValues());
    }

    public void delImg(String img_url){
        AliYunOSS.deleteFile(img_url);
    }
}
