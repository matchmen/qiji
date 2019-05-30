package com.qj.web.service.impl.service;

import com.qj.common.embed.ReturnResult;
import com.qj.common.utils.IdGenerator;
import com.qj.security.utils.PasswordEncode;
import com.qj.shop.domain.Shop;
import com.qj.shop.service.ShopService;
import com.qj.user.domain.Role;
import com.qj.user.domain.User;
import com.qj.user.service.RoleService;
import com.qj.user.service.UserService;
import com.qj.web.request.shop.ShopRegisterRequest;
import com.qj.web.service.ShopRegisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/****
 *
 * author:lqm
 * 2019-05-21
 **/
@Service
public class ShopRegisteServiceImpl implements ShopRegisteService {

    @Autowired
    private ShopService shopService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    @Transactional
    public ReturnResult<String> registeShop(ShopRegisterRequest request) {

        Shop shop = shopRegisterRequestConvert(request);

        shopService.registerShop(shop);

        Role role = roleService.getRoleByRoleCode("MASTER");

        User user = assembleUser(request, role,shop);

        userService.addUser(user);

        return new ReturnResult<String>(true,"注册成功");
    }

    private User assembleUser(ShopRegisterRequest request, Role role,Shop shop) {
        User user = new User();
        user.setName(request.getShopOwnerName());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setId(IdGenerator.generateId());
        user.setShopId(shop.getId());
        user.setRoleId(role.getId());
        user.setPassword(PasswordEncode.encode(request.getPassword1()));
        return user;
    }

    private Shop shopRegisterRequestConvert(ShopRegisterRequest request) {
        Shop shop = new Shop();
        shop.setShopName(request.getShopName());
        shop.setId(IdGenerator.generateId());
        return shop;
    }
}
