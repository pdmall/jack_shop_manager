package com.pdkj.jackmanager.service;

import com.pdkj.jackmanager.util.sql.Pager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShopService extends BaseService {

    public List<Map<String,Object>> getShopList(Integer state, Pager page) {
        return shopDao.getShopList(state,page);
    }
}
