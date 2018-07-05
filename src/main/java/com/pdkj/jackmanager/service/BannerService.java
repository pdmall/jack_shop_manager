package com.pdkj.jackmanager.service;

import com.pdkj.jackmanager.dao.BannerDao;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2018/06/26.
 */

@Service
public class BannerService extends BaseService<BannerDao> {

    public List<Map<String, Object>> getHomeBanner() {
        List<Map<String, Object>> shop = dao.getHomeBanner();
        return shop;
    }

}
