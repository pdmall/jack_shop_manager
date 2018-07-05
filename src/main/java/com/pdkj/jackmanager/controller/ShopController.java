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

    @PostMapping("updateShopPass")
    public Result updateShopPass(Shop shop,Integer state,String log) throws CustomException {
        if(state ==1){
            shopService.addShop(shop);
            shopService.delShop(shop.getId());
            ShopPassLog shopPassLog = new ShopPassLog();
            shopPassLog.setShop_id(shop.getId());
            shopPassLog.setReason(log);
            shopService.addShopPassLog(shopPassLog);
        }else{
            shopService.updateShop(shop.getId(),-2);
            ShopPassLog shopPassLog = new ShopPassLog();
            shopPassLog.setShop_id(shop.getId());
            shopPassLog.setReason(log);
            shopService.addShopPassLog(shopPassLog);
        }
        return ResultGenerator.genSuccessResult("审批完成");
    }



}
