package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import com.imooc.repository.ProductCategoryRepository;
import com.imooc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository repository;
    @Override
    public ProductCategory findOne(Integer categoryId) {
//        ProductCategory productCategory = new ProductCategory();
//        productCategory.setCategoryId(categoryId);
//        //创建一个牌匹配器，即如何使用查询条件
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withMatcher("categoryId", ExampleMatcher.GenericPropertyMatchers.exact());
//        //创建实例
//        Example<ProductCategory> example = Example.of(productCategory, matcher);
//        //查询
//        return repository.findOne(example).get();

        //Jpa版本高以上的换成findById();
        return repository.findById(categoryId).get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
