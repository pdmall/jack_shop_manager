package com.pdkj.jackmanager.dao;
/**
 * @Project: jack_shop
 * @Package com.pdkj.jack_shop.dao
 * @author lvchong
 * @date 2018/6/28 9:10
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.pdkj.jackmanager.bean.Banner;
import com.pdkj.jackmanager.util.Tools;
import com.pdkj.jackmanager.util.sql.SQLTools;
import com.pdkj.jackmanager.util.sql.SqlInfo;
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
public class BannerDao extends BaseDao{

    public List<Map<String, Object>> getHomeBanner() {
        String sql = "SELECT id,img_url,`type`,`value` from banner where is_available = 1";
        return jdbcTemplate.queryForList(sql);
    }
    public int addBanner(Banner banner){
        banner.setId(Tools.generatorId());
        SqlInfo insertSQL = SQLTools.getInsertSQL(banner);
        return jdbcTemplate.update(insertSQL.getSql(), insertSQL.getValues());
    }
}
