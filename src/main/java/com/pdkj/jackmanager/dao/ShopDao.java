package com.pdkj.jackmanager.dao;
import com.pdkj.jackmanager.util.sql.MySql;
/**
 * @Project: jack_shop
 * @Package com.pdkj.jack_shop.dao
 * @author lvchong
 * @date 2018/6/28 9:10
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.pdkj.jackmanager.bean.Shop;
import com.pdkj.jackmanager.util.sql.Pager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ShopDao extends BaseDao{

    public List<Map<String,Object>> getShopList(Integer state, Pager page) {
        MySql sql = new MySql();
        sql.append("SELECT * from shop where shop_state = ?",state);
        sql.limit(page);
        return jdbcTemplate.queryForList(sql.toString(), new Object[]{state});
    }

    public Map<String, Object> getShop(Long id) {
        String sql = " SELECT * FROM is_pass_shop where id = ? ";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, id);
        return map;
    }

    public List<Map<String, Object>> getIsPassShop(Integer state,Pager pager) {
        MySql sql = new MySql();
        sql.append("select * from is_pass_shop where shop_state = ?",state);
        sql.limit(pager);
        return jdbcTemplate.queryForList(sql.toString(), sql.getValues());
    }

    public int updateShop(Long id , int shop_state){
        String sql = "UPDATE `is_pass_shop`  SET `shop_state` = ?  WHERE `id` = ? ";
        return jdbcTemplate.update(sql,shop_state,id);
    }

}
