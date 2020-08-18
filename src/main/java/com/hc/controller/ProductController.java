package com.hc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hc.service.ProductCategoryService;
import com.hc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 张三
 * @since 2020-07-25
 */
@Controller
@RequestMapping("//product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/findByCategory/{type}/{id}")
    public ModelAndView findByCategory(@PathVariable("type") Integer type, @PathVariable("id") Integer id) {
        //根据类型和id取值
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productList");
        modelAndView.addObject("products", this.productService.findByLevle(type, id));
        modelAndView.addObject("list", this.productCategoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/findByKey")
    public ModelAndView findByKey(String keyWord) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("name", keyWord);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productList");
        modelAndView.addObject("products", this.productService.list(wrapper));
        modelAndView.addObject("list", this.productCategoryService.findAll());
        return modelAndView;
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productDetail");
        modelAndView.addObject("product", this.productService.getById(id));
        modelAndView.addObject("list", this.productCategoryService.findAll());
        return modelAndView;
    }

}

