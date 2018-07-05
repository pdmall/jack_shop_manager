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
import com.pdkj.jackmanager.util.sql.Pager;
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

    public List<Map<String, Object>> getHomeBanner(Pager pager) {
        String sql = "SELECT id,img_url,`type`,`value`,is_availabele from banner  limit "+(pager.getPage()-1)*pager.getRow()+","+pager.getRow();
        return jdbcTemplate.queryForList(sql);
    }
    public Long addBanner(Banner banner){
        banner.setId(Tools.generatorId());
        SqlInfo insertSQL = SQLTools.getInsertSQL(banner);
        jdbcTemplate.update(insertSQL.getSql(), insertSQL.getValues());
        return banner.getId();
    }
    public Long updateBanner(Banner banner){
        SqlInfo insertSQL = SQLTools.getUpdateById(banner,"banner",banner.getId());
        jdbcTemplate.update(insertSQL.getSql(), insertSQL.getValues());
        return banner.getId();
    }
}
