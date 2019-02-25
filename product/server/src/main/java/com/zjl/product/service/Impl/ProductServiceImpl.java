package com.zjl.product.service.Impl;

import com.zjl.product.client.output.ProductInfoOutput;
import com.zjl.product.dto.CartDTO;
import com.zjl.product.entity.ProductInfo;
import com.zjl.product.enums.ProductStatusEnum;
import com.zjl.product.enums.ResultEnum;
import com.zjl.product.exception.ProductException;
import com.zjl.product.repository.ProductInfoRepository;
import com.zjl.product.service.ProductService;
import com.zjl.product.utils.JsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Autowired
    private AmqpTemplate amqpTemplate;

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
        List<ProductInfo> infos = decreaseStockProcess(cartDTOList);
        List<ProductInfoOutput> productInfoOutputs = infos.stream().map(e -> {
            ProductInfoOutput output = new ProductInfoOutput();
            BeanUtils.copyProperties(e,output);
            return output;
        }).collect(Collectors.toList());
        amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(productInfoOutputs));
    }

    @Transactional
    public List<ProductInfo> decreaseStockProcess(List<CartDTO> cartDTOList) {
        List<ProductInfo> infos = new ArrayList<>();
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
            infos.add(productInfo);
        }
        return infos;
    }
}
