package com.zjl.product.service.Impl;

import com.netflix.discovery.converters.Auto;
import com.zjl.product.entity.ProductInfo;
import com.zjl.product.enums.ProductStatusEnum;
import com.zjl.product.repository.ProductInfoRepository;
import com.zjl.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.getByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
