package com.hc.service;

import com.hc.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hc.vo.CartVO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 张三
 * @since 2020-07-25
 */
public interface CartService extends IService<Cart> {
    public List<CartVO> findByUserId(Integer userId);
}
