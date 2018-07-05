package com.pdkj.jackmanager.controller;

import com.pdkj.jackmanager.core.Result;
import com.pdkj.jackmanager.core.ResultGenerator;
import com.pdkj.jackmanager.core.CustomException;
import com.pdkj.jackmanager.util.sql.Pager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("shop")
public class ShopController extends BaseController{

    @GetMapping("getShopList")
    public Result getSysUserList(Pager page, Integer state) {
        List<Map<String, Object>> users = shopService.getShopList(state, page);
        return ResultGenerator.genSuccessResult(users);
    }

    @GetMapping("getShopState")
    public Result getShopState(){
        List<Map<String, Object>> states = shopService.getShopState();
        return ResultGenerator.genSuccessResult(states);
    }

    @GetMapping("getShopByCheck")
    public Result getShopByCheck(Integer state,Pager pager) throws CustomException {
        return ResultGenerator.genSuccessResult(shopService.getShopByCheck(state,pager));
    }

    @GetMapping("updateShop")
    public Result updateShop(Long id , int shop_state) throws CustomException {
        return ResultGenerator.genSuccessResult(shopService.updateShop(id,shop_state));
    }

    @GetMapping("getShop")
    public Result getShop(Long id) throws CustomException {
        return ResultGenerator.genSuccessResult(shopService.getShop(id));
    }
}
