package com.hc.service.impl;

import com.hc.entity.UserAddress;
import com.hc.mapper.UserAddressMapper;
import com.hc.service.UserAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 张三
 * @since 2020-07-25
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {

}
