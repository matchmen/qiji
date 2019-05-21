package com.qj.shop.mapper;

import com.qj.shop.domain.Shop;
import org.apache.ibatis.annotations.Param;

/****
 *
 * author:lqm
 * 2019-05-21
 **/
public interface ShopMapper {

    void insertShop(Shop shop);

    Shop selectById(@Param("id") Long id);

    void updateShop(Shop shop);

}
