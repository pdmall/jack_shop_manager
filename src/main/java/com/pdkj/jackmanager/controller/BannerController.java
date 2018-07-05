package com.pdkj.jackmanager.controller;
/**
 * @Project: jackmanager
 * @Package com.pdkj.jackmanager.controller
 * @author lvchong
 * @date 2018/7/4 15:16
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.pdkj.jackmanager.core.CustomException;
import com.pdkj.jackmanager.core.Result;
import com.pdkj.jackmanager.core.ResultGenerator;
import com.pdkj.jackmanager.util.sql.Pager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvchong
 * @ClassName BannerController
 * @Description 类描述
 * @date 2018/7/4
 */

@RestController
@RequestMapping("banner")
public class BannerController extends BaseController {
    @GetMapping("getBanner")
    public Result getAllUser(Pager pager) throws CustomException {
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("updateBanner")
    public Result updateUser(String token) throws CustomException {
        return ResultGenerator.genSuccessResult();
    }
    @GetMapping("AddBanner")
    public Result AddBanner(String token) throws CustomException {
        return ResultGenerator.genSuccessResult();
    }
}
