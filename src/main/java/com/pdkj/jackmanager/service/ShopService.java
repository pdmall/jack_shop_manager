package com.pdkj.jackmanager.service;


import com.pdkj.jackmanager.bean.Shop;
import com.pdkj.jackmanager.bean.ShopPassLog;
import com.pdkj.jackmanager.core.CustomException;
import com.pdkj.jackmanager.dao.ShopDao;
import com.pdkj.jackmanager.util.Tools;
import com.pdkj.jackmanager.util.sql.Pager;
import com.pdkj.jackmanager.util.sql.SQLTools;
import com.pdkj.jackmanager.util.sql.SqlInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShopService extends BaseService {

    public List<Map<String,Object>> getShopList(Integer state, Pager page) {
        if(state!=null&&state>=1){
            return shopDao.getShopList(state,page);
        }else{
            return shopDao.getShopByCheck(state,page);
        }
    }

    public Map<String, Object> getShop(Long id) {
        return shopDao.getShop(id);
    }

    public List<Map<String, Object>> getShopByCheck(Integer state,Pager page) {
        return shopDao.getShopByCheck(state,page);
    }

    public int updateShop(Long id , int shop_state){
        return shopDao.updateShop(id,shop_state);
    }

    public List<Map<String,Object>> getShopState() {
        return shopDao.getShopState();
    }

    public Long addShopPassLog(ShopPassLog shopPassLog){

        return shopDao.addShopPassLog(shopPassLog);
    }
    public Long addShop(Shop shop){
        return shopDao.addShop(shop);
    }
    public void delShop(Long id){
        shopDao.delShop(id);
    }
}
