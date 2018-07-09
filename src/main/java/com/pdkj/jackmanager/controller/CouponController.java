package com.pdkj.jackmanager.controller;

import com.pdkj.jackmanager.core.CustomException;
import com.pdkj.jackmanager.core.Result;
import com.pdkj.jackmanager.core.ResultGenerator;
import com.pdkj.jackmanager.util.sql.Pager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("coupon")
public class CouponController extends BaseController{

    @GetMapping("getCouponList")
    public Result getCouponList(Long id, Pager page, Integer state) {
        return ResultGenerator.genSuccessResult(couponService.getCouponList(state, page,id));
    }

    @GetMapping("updateCoupon")
    public Result updateCoupon(Long id , int shop_state) throws CustomException {
        return ResultGenerator.genSuccessResult(couponService.updateCoupon(id,shop_state));
    }

    @GetMapping("getCoupon")
    public Result getCoupon(Long id) throws CustomException {
        return ResultGenerator.genSuccessResult(couponService.getCoupon(id));
    }

}
