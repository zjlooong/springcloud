package com.zjl.product.service;

import com.zjl.product.entity.ProductInfo;

import java.util.List;

public interface ProductService {
    /**
     *查询所有在架商品
     */
    List<ProductInfo> findUpAll();
}
