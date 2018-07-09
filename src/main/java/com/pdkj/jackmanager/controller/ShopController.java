package com.pdkj.jackmanager.controller;

import com.pdkj.jackmanager.bean.Shop;
import com.pdkj.jackmanager.bean.ShopPassLog;
import com.pdkj.jackmanager.core.Result;
import com.pdkj.jackmanager.core.ResultGenerator;
import com.pdkj.jackmanager.core.CustomException;
import com.pdkj.jackmanager.util.sql.Pager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("shop")
public class ShopController extends BaseController {

    @GetMapping("getShopList")
    public Result getSysUserList(Pager page, Integer state) {
        return ResultGenerator.genSuccessResult(shopService.getShopList(state, page));
    }

    @GetMapping("getShopState")
    public Result getShopState() {
        return ResultGenerator.genSuccessResult(shopService.getShopState());
    }

    @GetMapping("getShopByCheck")
    public Result getShopByCheck(Integer state, Pager pager) throws CustomException {
        return ResultGenerator.genSuccessResult(shopService.getShopByCheck(state, pager));
    }

    @GetMapping("updateShop")
    public Result updateShop(Long id, int shop_state) throws CustomException {
        return ResultGenerator.genSuccessResult(shopService.updateShop(id, shop_state));
    }

    @GetMapping("getShop")
    public Result getShop(Long id) throws CustomException {
        return ResultGenerator.genSuccessResult(shopService.getShop(id));
    }

    @PostMapping("updateShopPass")
    public Result updateShopPass(Long shop_id, Integer isPass, String log) throws CustomException {
        return ResultGenerator.genSuccessResult(shopService.updateShopPass(shop_id, isPass, log));
    }

    @PostMapping("getUserAllShop")
    public Result getUserAllShop(Long user_id , Pager pager) throws CustomException {
        return ResultGenerator.genSuccessResult(shopService.getUserAllShop(user_id,pager));
    }

}
