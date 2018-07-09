package com.pdkj.jackmanager.dao;

import com.pdkj.jackmanager.bean.Coupon;
import com.pdkj.jackmanager.bean.IsPassCoupon;
import com.pdkj.jackmanager.util.Tools;
import com.pdkj.jackmanager.util.sql.MySql;
import com.pdkj.jackmanager.util.sql.Pager;
import com.pdkj.jackmanager.util.sql.SQLTools;
import com.pdkj.jackmanager.util.sql.SqlInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Project: jack_shop
 * @Package com.pdkj.jack_shop.dao
 * @author lvchong
 * @date 2018/6/28 9:10
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

@Repository
public class CouponDao extends BaseDao{

    public List<Map<String,Object>> getCouponList(Integer state, Pager page) {
        MySql sql = new MySql();

        sql.append("SELECT * from coupon where coupon_state = ?",state);
        sql.limit(page);
        return jdbcTemplate.queryForList(sql.toString(),sql.getValues());
    }
    public List<Map<String,Object>> getIsPassCouponList(Integer state, Pager page) {
        MySql sql = new MySql();
        sql.append("SELECT * from is_pass_coupon where coupon_state = ?",state);
        sql.limit(page);
        return jdbcTemplate.queryForList(sql.toString(),sql.getValues());
    }
    public Map<String, Object> getCoupon(Long id) {
        String sql = " SELECT * FROM is_pass_coupon where id = ? ";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, id);
        return map;
    }

    public int updateCoupon(Long id , int shop_state){
        String sql = "UPDATE `is_pass_coupon`  SET `coupon_state` = ?  WHERE `id` = ? ";
        return jdbcTemplate.update(sql,shop_state,id);
    }


}
