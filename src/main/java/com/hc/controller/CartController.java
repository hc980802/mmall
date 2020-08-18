package com.hc.controller;


import com.hc.entity.Cart;
import com.hc.entity.User;
import com.hc.enums.ResultEnum;
import com.hc.exception.MallException;
import com.hc.service.CartService;
import com.hc.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 张三
 * @since 2020-07-25
 */
@Controller
@RequestMapping("//cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/add/{id}/{price}/{quantity}")
    public ModelAndView add(
            @PathVariable("id") Integer id,
            @PathVariable("price") Float price,
            @PathVariable("quantity") Integer quantity,
            HttpSession session) {
        try {
            User user = (User) session.getAttribute("user");
            if (user == null) {
                throw new MallException(ResultEnum.NOT_LOGIN);
            }
            Cart cart = new Cart(id, quantity, price * quantity, user.getId());
            this.cartService.save(cart);
            //查询对应的购物车记录并返回
            List<CartVO> list = this.cartService.findByUserId(user.getId());
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("settlement1");
            modelAndView.addObject("list", list);
            return modelAndView;
        } catch (Exception e) {
            throw new MallException(ResultEnum.ORDER_ERROR);
        }
    }
}

