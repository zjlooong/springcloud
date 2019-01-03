package com.zjl.product.service.Impl;

import com.zjl.product.dto.CartDTO;
import com.zjl.product.entity.ProductInfo;
import com.zjl.product.enums.ProductStatusEnum;
import com.zjl.product.enums.ResultEnum;
import com.zjl.product.exception.ProductException;
import com.zjl.product.repository.ProductInfoRepository;
import com.zjl.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.getByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIds) {
        return repository.findByProductIdIn(productIds);
    }

    @Override
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList) {
            Optional<ProductInfo> productInfoOptional = repository.findById(cartDTO.getProductId());
            if(!productInfoOptional.isPresent()){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = productInfoOptional.get();

            //判断库存
            Integer res = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (res<0){
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(res);
            repository.save(productInfo);
        }
    }
}
