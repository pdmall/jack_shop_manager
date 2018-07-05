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

import java.util.List;
import java.util.Map;

/**
 * @author lvchong
 * @ClassName BannerController
 * @Description 类描述
 * @date 2018/7/4
 */

@RestController
@RequestMapping("shop")
public class ShopController extends BaseController {
    @GetMapping("getShopList")
    public Result getShopList(Pager pager) throws CustomException {
        return ResultGenerator.genSuccessResult(shopService.getShopList(pager));
    }

    @GetMapping("getShopByCheck")
    public Result getShopByCheck(Pager pager) throws CustomException {
        return ResultGenerator.genSuccessResult(shopService.getShopByCheck(pager));
    }

    @GetMapping("updateShop")
    public Result updateShop(int id , int shop_state) throws CustomException {
        return ResultGenerator.genSuccessResult(shopService.updateShop(id,shop_state));
    }
    @GetMapping("getShop")
    public Result getShop(Long id) throws CustomException {
        return ResultGenerator.genSuccessResult(shopService.getShop(id));
    }
}
