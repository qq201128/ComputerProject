package com.cy.store.mapper;

import com.cy.store.entity.User;
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
public class UserMapperTests {
    //idea有检测的功能,接口是不能直接创建bean对象的(动态代理技术来解决)
    @Autowired
    private UserMapper userMapper;
    /**
     * 单元测试类满足以下几点可以单独运行
     * 1.必须被@test修饰2.返回值类型必须是void3.方法的参数列表不指定任何类型4.方法的访问修饰符必须是public
     */
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("tim");
        user.setPassword("123");
        Integer rows=userMapper.insert(user);
        System.out.println(rows);
    }
    @Test
    public void  findByUsername(){
        User user = userMapper.findByUsername("tim");
        System.out.println(user);
    }


    @Test
    public void updatePasswordByUid(){
        userMapper.updatePasswordByUid(11,"321"
                ,"管理员",new Date());
    }

    @Test
    public void findByUid(){
        System.out.println(userMapper.findByUid(11));
    }

    @Test
    public void updateInfoByUid(){
        User user =new User();
        user.setUid(12);
        user.setPhone("13555555555");
        user.setEmail("111@11.com");
        user.setGender(1);
        userMapper.updateInfoByUid(user);
    }


    @Test
    public void updateAvatarByUid(){
        userMapper.updateAvatarByUid(13,"/upload/avatar.png","管理员",new Date());
    }
}
