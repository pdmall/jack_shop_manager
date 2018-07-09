package com.pdkj.jackmanager.service;

import com.pdkj.jackmanager.util.sql.Pager;
import com.pdkj.jackmanager.dao.UserDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService extends BaseService{


    public List<Map<String,Object>> getUserList(Integer state, Pager page, String key) {
        return userDao.getUserList(state,page,key);
    }
    public void delImg(String img_url){
        userDao.delImg(img_url);
    }
}
