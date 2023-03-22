package com.cy.store.mapper;

import com.cy.store.entity.Address;
import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

//@SpringBootTest表示当前的类是测试类,不会随同项目一起打包发送
//RunWith:表示启动单元测试类.需要传递参数,参数必须是springrunner的实例类型
@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressMapperTests {

    @Autowired
    private  AddressMapper addressMapper;

    @Test
    public  void insert(){
        Address address = new Address();
        address.setUid(13);
        address.setPhone("13444444444");
        address.setName("女朋友");
        addressMapper.insert(address);
    }

    @Test
    public  void countByUid(){
        Integer count = addressMapper.countByUid(13);
        System.out.println(count);

    }


    @Test
    public void findByUid(){
        List<Address> list = addressMapper.findByUid(13);
        System.out.println(list);
    }

    @Test
    public void findByAid() {
        System.err.println(addressMapper.findByAid(6));
    }

    @Test
    public void updateNonDefault(){
        addressMapper.updateNonDefault(13);
    }
    @Test
    public void updateDefaultByAid(){
        addressMapper.updateDefaultByAid(6,"管理员",new Date());
    }

    @Test
    public void deleteByAid(){
        addressMapper.deleteByAid(1);
    }

    @Test
    public void findLastModified(){
        System.out.println(addressMapper.findLastModified(13));
    }

}
