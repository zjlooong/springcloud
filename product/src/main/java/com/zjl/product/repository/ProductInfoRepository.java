package com.zjl.product.repository;

import com.zjl.product.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String > {

    List<ProductInfo> getByProductStatus(Integer productStatus);
}
