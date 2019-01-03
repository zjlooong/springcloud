package com.zjl.product.controller;

import com.zjl.product.dto.CartDTO;
import com.zjl.product.entity.ProductCategory;
import com.zjl.product.entity.ProductInfo;
import com.zjl.product.service.ProductCategoryService;
import com.zjl.product.service.ProductService;
import com.zjl.product.vo.InvokeResult;
import com.zjl.product.vo.ProductInfoVO;
import com.zjl.product.vo.ProductVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService categoryService;

    @GetMapping("/list")
    public InvokeResult<ProductVO> list(){
        List<ProductInfo> upAll = productService.findUpAll();
        List<Integer> types = upAll.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        List<ProductCategory> categories = categoryService.findByCategoryTypeIn(types);

        List<ProductVO> productVOs = new ArrayList<>();
        for (ProductCategory productCategory: categories) {
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(productCategory,productVO);

            List<ProductInfoVO> productInfoVOs = new ArrayList<>();
            for (ProductInfo productInfo: upAll) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO vo = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,vo);
                    productInfoVOs.add(vo);
                }
            }
            productVO.setProductInfoVOs(productInfoVOs);
            productVOs.add(productVO);
        }
        return InvokeResult.success(productVOs);
    }

    /**
     * 获取商品列表（给订单服务使用）
     * @param products
     * @return
     */
    @PostMapping("listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> products){
        return productService.findList(products);
    }

    @PostMapping("decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList){
        productService.decreaseStock(cartDTOList);
    }
}
