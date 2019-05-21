package com.qj.shop.service.impl;

import com.qj.common.embed.ReturnResult;
import com.qj.shop.domain.Shop;
import com.qj.shop.mapper.ShopMapper;
import com.qj.shop.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/****
 *
 * author:lqm
 * 2019-05-21
 **/
@Slf4j
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    @Transactional
    public ReturnResult<String> registerShop(Shop shop) {

        shopMapper.insertShop(shop);
        return new ReturnResult<>(true,"操作成功");
    }

    @Override
    @Transactional
    public ReturnResult<String> perfectShopInfo(Shop shop) {
        shopMapper.updateShop(shop);
        return new ReturnResult<>(true,"操作成功");
    }

    @Override
    @Transactional
    public ReturnResult<String> updateShopInfo(Shop shop) {
        shopMapper.updateShop(shop);
        return new ReturnResult<>(true,"操作成功");
    }

    @Override
    public ReturnResult<Shop> getShopInfo(Long id) {
        Shop shop = shopMapper.selectById(id);

        return new ReturnResult<>(true, "操作成功",shop);
    }
}
