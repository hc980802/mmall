package com.hc.service;

import com.hc.entity.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hc.vo.ProductCategoryVO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 张三
 * @since 2020-07-25
 */
public interface ProductCategoryService extends IService<ProductCategory> {
    public List<ProductCategoryVO> findAll();
}
