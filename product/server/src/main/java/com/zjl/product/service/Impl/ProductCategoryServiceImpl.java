package com.zjl.product.service.Impl;

import com.zjl.product.entity.ProductCategory;
import com.zjl.product.repository.ProductCategoryRepository;
import com.zjl.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes) {
        return repository.findByCategoryTypeIn(categoryTypes);
    }
}
