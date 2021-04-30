package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.unit.DataUnit;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
//        Optional<ProductCategory> productCategory = repository.findById(1);
//        System.out.println(productCategory.toString());

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1);
        //将匹配对象封装成Example对象
        Example<ProductCategory> example = Example.of(productCategory);
        //根据id精准匹配对象，id必须是唯一主键，查出2条会报错
        Optional<ProductCategory> one = repository.findOne(example);
//        List<ProductCategory> one = repository.findAll(example);
        System.out.println(one.toString());
    }
//    @Test
//    public void saveTest(){
//        ProductCategory productCategory = new ProductCategory();
//        productCategory.setCategoryId(1);
//        productCategory.setCategoryName("热销榜1");
//        productCategory.setCategoryType(3);
//        repository.save(productCategory);
//
//    }

    /**
     * 修改
     */
    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(7);
        //将匹配对象封装成Example对象
        Example<ProductCategory> example = Example.of(productCategory);
        //根据id精准匹配对象，id必须是唯一主键，查出2条会报错
        Optional<ProductCategory> one = repository.findOne(example);
        productCategory.setCategoryType(10);
        productCategory.setCategoryName("女生专享");
        repository.save(productCategory);
    }

    /**
     * 查询符合条件的多条数据
     */
    @Test
    public void findAllTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("热");
        //创建匹配器，即如何使用查询条件
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
//                .withMatcher("categoryName", ExampleMatcher.GenericPropertyMatchers.endsWith());//endsWith是categoryName 结尾为“最爱”的数据
                .withMatcher("categoryName", ExampleMatcher.GenericPropertyMatchers.startsWith());
//                .withIgnorePaths("isFace");//isFace字段不参与匹配，或者可以说：忽略名为"isFace"的属性路径
        //创建实例
        Example<ProductCategory> example = Example.of(productCategory, exampleMatcher);
        //查询
        List<ProductCategory> one = repository.findAll(example);
        System.out.println(one.toString());
    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }

}