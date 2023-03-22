package com.cy.store.mapper;

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
public class DistrictMapperTests {
    @Autowired
    private  DistrictMapper districtMapper;

    @Test
    public  void findByParent(){
        List<District> list = districtMapper.findByParent("210100");
        for (District d:list) {
            System.out.println(d);
        }
    }


    @Test
    public void findNameByCode(){
        String name = districtMapper.findNameByCode("610000");
        System.out.println(name);
    }
}
