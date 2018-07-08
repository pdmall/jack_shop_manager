package com.pdkj.jackmanager.service;


import com.pdkj.jackmanager.util.sql.Pager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CouponService extends BaseService {

    public List<Map<String,Object>> getCouponList(Integer state, Pager page) {
        return couponDao.getCouponList(state,page);
    }
    public List<Map<String,Object>> getIsPassCouponList(Integer state, Pager page) {
        return couponDao.getIsPassCouponList(state,page);
    }
    public Map<String, Object> getCoupon(Long id) {
        return couponDao.getCoupon(id);
    }

    public int updateCoupon(Long id , int shop_state){
        return couponDao.updateCoupon(id,shop_state);
    }

}
