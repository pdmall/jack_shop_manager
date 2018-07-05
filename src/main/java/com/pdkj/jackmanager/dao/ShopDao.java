package com.pdkj.jackmanager.dao;

import com.pdkj.jackmanager.util.sql.MySql;
import com.pdkj.jackmanager.util.sql.Pager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ShopDao extends BaseDao{

    public List<Map<String,Object>> getShopList(Integer state, Pager page) {
        MySql sql = new MySql("SELECT * from shop where shop_state = ?");
        sql.limit(page);
        List<Map<String,Object>> shop = jdbcTemplate.queryForList(sql.toString(), new Object[]{state});
        return shop;
    }
}
