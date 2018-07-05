package com.pdkj.jackmanager.service;


import com.pdkj.jackmanager.core.CustomException;
import com.pdkj.jackmanager.dao.ShopDao;
import com.pdkj.jackmanager.util.sql.Pager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShopService extends BaseService {

    public List<Map<String,Object>> getShopList(Integer state, Pager page) {
        return shopDao.getShopList(state,page);
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
