package com.cy.store.service;

import com.cy.store.entity.Address;
import com.cy.store.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//@SpringBootTest表示当前的类是测试类,不会随同项目一起打包发送
//RunWith:表示启动单元测试类.需要传递参数,参数必须是springrunner的实例类型
@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictServiceTests {
    @Autowired
    private IDistrictService districtService;

    @Test
    public  void getByParent(){
        //86代表中国，所有省的父代号都是86
        List<District> list = districtService.getByParent("86");
        for (District d:list) {
            System.out.println(d);
        }
    }


}
