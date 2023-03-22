package com.cy.store.mapper;

import com.cy.store.entity.Address;
import com.cy.store.entity.Cart;
import com.cy.store.vo.CartVO;
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
public class CartMapperTests {
    @Autowired
    private CartMapper cartMapper;
    @Test
    public  void insert(){
        Cart cart = new Cart();
        cart.setUid(13);
        cart.setPid(10000004);
        cart.setNum(3);
        cart.setPrice(100L);
        cartMapper.insert(cart);
    }

    @Test
    public void updateNumByCid() {
        cartMapper.updateNumByCid(1, 10, "管理员", new Date());
    }
    @Test
    public void findByUidAndPid() {
        Cart result = cartMapper.findByUidAndPid(13, 10000004);
        System.out.println(result);

    }

    @Test
    public void findVOByUid() {
        System.out.println(cartMapper.findVOByUid(13));

    }

    @Test
    public void findByCid() {
        Integer cid = 3;
        Cart result = cartMapper.findByCid(cid);
        System.out.println(result);
    }

    @Test
    public void findVOByCids() {
        Integer[] cids = {1, 2, 6, 7, 8, 9, 10};
        List<CartVO> list = cartMapper.findVOByCids(cids);
        System.out.println("count=" + list.size());
        for (CartVO item : list) {
            System.out.println(item);
        }
    }


}
