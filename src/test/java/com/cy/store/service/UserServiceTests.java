package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

//@SpringBootTest表示当前的类是测试类,不会随同项目一起打包发送
//RunWith:表示启动单元测试类.需要传递参数,参数必须是springrunner的实例类型
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {
    //idea有检测的功能,接口是不能直接创建bean对象的(动态代理技术来解决)
    @Autowired
    private IUserService userService;
    /**
     * 单元测试类满足以下几点可以单独运行
     * 1.必须被@test修饰2.返回值类型必须是void3.方法的参数列表不指定任何类型4.方法的访问修饰符必须是public
     */
    @Test
    public void reg(){
        try {
            User user = new User();
            user.setUsername("ali2");
            user.setPassword("123");
            userService.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            //获取类的对象,再获取类的名称
            System.out.println(e.getClass().getSimpleName());
            //获取异常的集体描述信息
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void  login(){
        User user = userService.login("ali1","123");
        System.out.println(user);
    }
    @Test
    public void changePassword(){
        userService.changePassword(12,"ali2","123","321");
    }
    @Test
    public void getByUid(){
        System.out.println(userService.getByUid(12));
    }


    @Test
    public void changeInfo(){
        User user = new User();
        user.setPhone("13444444444");
        user.setEmail("123@163.com");
        user.setGender(0);
        userService.changeInfo(12,"ali2", user);
    }

    @Test
    public void changeAvatar(){
        userService.changeAvatar(13,"/upload/test.png","张三");
    }
}
