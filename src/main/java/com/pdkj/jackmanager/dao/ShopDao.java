package com.pdkj.jackmanager.dao;
import com.pdkj.jackmanager.bean.ShopPassLog;
import com.pdkj.jackmanager.util.Tools;
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
import com.pdkj.jackmanager.util.sql.SQLTools;
import com.pdkj.jackmanager.util.sql.SqlInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ShopDao extends BaseDao{

    public List<Map<String,Object>> getShopList(Integer state, Pager page) {
        MySql sql = new MySql();
        sql.append("SELECT * from shop where shop_state = ? order by updated DESC",state);
        sql.limit(page);
        return jdbcTemplate.queryForList(sql.toString(), new Object[]{state});
    }

    public List<Map<String,Object>> getShopState(){
        MySql sql = new MySql("SELECT * from shop_state order by updated DESC");
        List<Map<String, Object>> shop = jdbcTemplate.queryForList(sql.toString());
        return shop;
    }

    public Map<String, Object> getIsPassShop(Long id) {
        String sql = " SELECT * FROM is_pass_shop where id = ?  order by updated DESC";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, id);
        return map;
    }
    public Map<String, Object> getShop(Long id) {
        MySql sql = new MySql();
        sql.append("SELECT");
        sql.append(" shop.id,name,shop_name,shop_address,province,street,city,county,shop_phone,shop_state,buss_open,buss_close,");
        sql.append(" longitude,latitude,average_cons,introduce,license_img,service_score,enviro_score,taste_score,");
        sql.append(" home_img,detail_imgs FROM shop,label where shop.id = ? and label.shop_id = shop.id",id);
        Map<String, Object> map = jdbcTemplate.queryForMap(sql.toString(), sql.getValues());
        return map;
    }
    public Map<String, Object> getShopById(Long id){
        MySql sql = new MySql();
        sql.append("select * from is_pass_shop where id = ?",id);
        return jdbcTemplate.queryForMap(sql.toString(),sql.getValues());
    }

    public List<Map<String, Object>> getShopByCheck(Integer state,Pager pager) {
        MySql sql = new MySql();
        sql.append("select * from is_pass_shop where 1=1");
        sql.notNullAppend("and shop_state = ? order by updated DESC", state);
        sql.limit(pager);
        List<Map<String, Object>> map = jdbcTemplate.queryForList(sql.toString(), sql.getValues());
        return map;
    }

    public int updateShop(Long id , int shop_state){
        String sql = "UPDATE `is_pass_shop`  SET `shop_state` = ?  WHERE `id` = ? ";
        return jdbcTemplate.update(sql,shop_state,id);
    }

    public Long addShopPassLog(ShopPassLog shopPassLog){
        shopPassLog.setId(Tools.generatorId());
        SqlInfo sqlInfo = SQLTools.getInsertSQL(shopPassLog,"shop_pass_log");
        jdbcTemplate.update(sqlInfo.getSql(),sqlInfo.getValues());
        return shopPassLog.getId();
    }


    public Long addShop(Shop shop){
        SqlInfo sqlInfo = SQLTools.getInsertSQL(shop,"shop");
        jdbcTemplate.update(sqlInfo.getSql(),sqlInfo.getValues());
        return shop.getId();
    }

    public void delShop(Long id){
        MySql sql = new MySql();
        sql.append("DELETE FROM is_pass_shop where id = ?",id);
        jdbcTemplate.update(sql.toString(), sql.getValues());
    }

    public List<Map<String, Object>> getUserAllShop(Long user_id,Pager pager) {
        MySql sql = new MySql();
        sql.append("SELECT shop_name,id,shop_address,home_img FROM shop s,user_shop_rel usr  ");
        sql.append(" WHERE s.id = usr.shop_id and user_id = ? order by updated DESC",user_id);
        sql.limit(pager);
        return jdbcTemplate.queryForList(sql.toString(), sql.getValues());
    }
    public List<Map<String, Object>> getUserAllIsPassShop(Long user_id,Pager pager) {
        MySql sql = new MySql();
        sql.append("SELECT shop_name,id,shop_address,home_img FROM getUserAllIsPassShop s,user_shop_rel usr  ");
        sql.append(" WHERE s.id = usr.shop_id and user_id = ? order by updated DESC",user_id);
        sql.limit(pager);
        return jdbcTemplate.queryForList(sql.toString(), sql.getValues());
    }


}
