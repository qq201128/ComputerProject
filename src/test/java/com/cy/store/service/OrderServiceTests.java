package com.cy.store.service;

import com.cy.store.entity.Address;
import com.cy.store.entity.Order;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@SpringBootTest表示当前的类是测试类,不会随同项目一起打包发送
//RunWith:表示启动单元测试类.需要传递参数,参数必须是springrunner的实例类型
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTests {
    @Autowired
    private IOrderService orderService;

    @Test
    public void create() {

            Integer[] cids = {3, 4};
            Order order = orderService.create(6,13,"管理员",cids);
            System.out.println(order);


    }
}
