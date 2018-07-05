package com.pdkj.jackmanager.service;

import com.pdkj.jackmanager.bean.Banner;
import com.pdkj.jackmanager.dao.BannerDao;
import com.pdkj.jackmanager.util.sql.Pager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2018/06/26.
 */

@Service
public class BannerService extends BaseService<BannerDao> {

    public List<Map<String, Object>> getHomeBanner(Pager pager) {
        List<Map<String, Object>> shop = bannerDao.getHomeBanner(pager);
        return shop;
    }

    public Long updateBanner(Banner banner) {
        return bannerDao.updateBanner(banner);
    }
    public Long addBanner(Banner banner) {
        return bannerDao.addBanner(banner);
    }
}
