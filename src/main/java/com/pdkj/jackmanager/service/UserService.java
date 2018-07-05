package com.pdkj.jackmanager.service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.pdkj.jackmanager.dao.UserDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * Created by CodeGenerator on 2018/06/26.
 */

@Service
public class UserService extends BaseService<UserDao> {


}
