package com.hc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hc.entity.Cart;
import com.hc.entity.Product;
import com.hc.mapper.CartMapper;
import com.hc.mapper.ProductMapper;
import com.hc.service.CartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hc.vo.CartVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 张三
 * @since 2020-07-25
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<CartVO> findByUserId(Integer userId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id", userId);
        List<Cart> list = this.cartMapper.selectList(wrapper);
        List<CartVO> voList = new ArrayList<>();
        for (Cart cart : list) {
            CartVO cartVO = new CartVO();
            BeanUtils.copyProperties(cart, cartVO);
            Product product = this.productMapper.selectById(cart.getProductId());
            BeanUtils.copyProperties(product, cartVO);
            voList.add(cartVO);
        }
        return voList;
    }
}
