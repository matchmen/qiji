package com.qj.shop.service;

import com.qj.common.embed.ReturnResult;
import com.qj.shop.domain.Shop;

/****
 * author:lqm
 * 2019-05-21
 **/
public interface ShopService {

    ReturnResult<String> registerShop(Shop shop);

    ReturnResult<String> perfectShopInfo(Shop shop);

    ReturnResult<String> updateShopInfo(Shop shop);

    ReturnResult<Shop> getShopInfo(Long id);


}
