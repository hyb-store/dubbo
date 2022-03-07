package com.hyb.gmall.service.impl;

import com.hyb.gmall.bean.UserAddress;
import com.hyb.gmall.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@DubboService
@Service
public class UserServiceImpl implements UserService {

    public List<UserAddress> getUserAddressList(String userId) {

        System.out.println("UserServiceImpl.....old...");

        UserAddress address1 = new UserAddress(1, "北京市昌平区", "1", "李四", "010-56253825", "Y");
        UserAddress address2 = new UserAddress(2, "深圳市宝安区", "1", "王五", "010-56253825", "N");

        return Arrays.asList(address1,address2);
    }

}
