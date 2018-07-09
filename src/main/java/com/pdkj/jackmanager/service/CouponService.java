package com.pdkj.jackmanager.service;


import com.alibaba.fastjson.JSON;
import com.pdkj.jackmanager.bean.CouponPassLog;
import com.pdkj.jackmanager.bean.Shop;
import com.pdkj.jackmanager.bean.ShopPassLog;
import com.pdkj.jackmanager.util.sql.Pager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CouponService extends BaseService {

    public List<Map<String,Object>> getCouponList(Integer state, Pager page,Long id) {
        if(state>0)
            return couponDao.getCouponList(state,page, id);
        else
            return couponDao.getIsPassCouponList(state,page,id);

    }
    public Map<String, Object> getCoupon(Long id) {
        return couponDao.getCoupon(id);
    }

    public int updateCoupon(Long id , int shop_state){
        return couponDao.updateCoupon(id,shop_state);
    }

    public String updateCouponPass(Long shop_id, Integer isPass, String log) {
        CouponPassLog couponPassLog = new CouponPassLog();
        couponPassLog.setShop_id(shop_id);
        couponPassLog.setReason(log);
        couponDao.addCouponPassLog(couponPassLog);
        if(isPass == 1){
            Shop shop = null;
            if(shopDao.getShopById(shop_id).size()>0){
                shop = JSON.parseObject(JSON.toJSONString(shopDao.getShopById(shop_id)), Shop.class);
                shop.setShop_state("1");
            }else{
                return "没有该商铺";
            }
            shopDao.addShop(shop);
            shopDao.delShop(shop.getId());
        }else{
           // updateShop(shop_id,-2);
        }
        return "审核完成";
    }


}
