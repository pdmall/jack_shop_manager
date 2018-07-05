package com.pdkj.jackmanager.bean;
/**
 * @Project: jack_shop
 * @Package com.pdkj.jack_shop.model
 * @author lvchong
 * @date 2018/6/29 14:46
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.Date;

/**
 * @author lvchong
 * @ClassName banner
 * @Description 类描述
 * @date 2018/6/29
 */
public class ShopPassLog {
    private Long id;
    private Long shop_id;
    private String reason;
    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
