package com.pdkj.jackmanager.service;


import com.pdkj.jackmanager.core.CustomException;
import com.pdkj.jackmanager.dao.ShopDao;
import com.pdkj.jackmanager.util.sql.Pager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2018/06/26.
 */

@Service
public class ShopService extends BaseService<ShopDao> {

    public List<Map<String, Object>> getShopList(Pager page) {
        return shopDao.getShopList(page);
    }
    public Map<String, Object> getShop(Long id) {
        return shopDao.getShop(id);
    }
    public List<Map<String, Object>> getShopByCheck(Pager page) {
        return shopDao.getShopByCheck(page);
    }

    public int updateShop(Long id , int shop_state){
        return shopDao.updateShop(id,shop_state);
    }

}
