package com.zjl.product.service;

import com.zjl.product.dto.CartDTO;
import com.zjl.product.entity.ProductInfo;

import java.util.List;

public interface ProductService {
    /**
     *查询所有在架商品
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIds
     * @return
     */
    List<ProductInfo> findList(List<String> productIds);

    /**
     * 扣库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
