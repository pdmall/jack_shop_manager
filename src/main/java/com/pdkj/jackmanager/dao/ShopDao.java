package com.pdkj.jackmanager.dao;
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

/**
 * @author lvchong
 * @ClassName ShopDao
 * @Description 类描述
 * @date 2018/6/28
 */
@Repository
public class ShopDao extends BaseDao {

    public List<Map<String, Object>> getShopList(Pager pager) {
       String sql = "select * from is_pass_shop limit "+(pager.getPage()-1)*pager.getRow()+","+pager.getRow();
        return jdbcTemplate.queryForList(sql);
    }
    public Map<String, Object> getShop(Long id) {
        String sql = " SELECT * FROM is_pass_shop where id = ? ";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, id);
        return map;
    }
    public List<Map<String, Object>> getShopByCheck(Pager pager) {
        String sql = "select * from is_pass_shop where shop_state = -1 limit "+(pager.getPage()-1)*pager.getRow()+","+pager.getRow();
        List<Map<String, Object>> map = jdbcTemplate.queryForList(sql);
        return map;
    }

    public int updateShop(Long id , int shop_state){
        String sql = "UPDATE `is_pass_shop`  SET `shop_state` = ?  WHERE `id` = ? ";
        return jdbcTemplate.update(sql,shop_state,id);
    }
}
