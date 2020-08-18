package com.hc.service.impl;

import com.hc.entity.Orders;
import com.hc.mapper.OrdersMapper;
import com.hc.service.OrdersService;
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
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

}
