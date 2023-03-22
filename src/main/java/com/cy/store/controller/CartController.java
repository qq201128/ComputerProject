package com.cy.store.controller;

import com.cy.store.service.ICartService;
import com.cy.store.util.JsonResult;
import com.cy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("carts")
public class CartController extends  BaseController{
    @Autowired
    private ICartService cartService;

    @RequestMapping("add_to_cart")
    private JsonResult<Void> addToCart(Integer pid,Integer amount,HttpSession session){
        cartService.addToCart(getUidFromSession(session),
                pid,amount,
                getUsernameSession(session));
        return new JsonResult<>(OK);
    }

    @RequestMapping({"","/"})
    private JsonResult<List<CartVO>> getVOByUid(HttpSession session){
        List<CartVO> data = cartService.getVOByUid(getUidFromSession(session));
        return new JsonResult<>(OK,data);
    }
    @RequestMapping("{cid}/num/add")
    private JsonResult<Integer> addNum(@PathVariable("cid") Integer cid, HttpSession session){
        Integer data = cartService.addNum(cid,getUidFromSession(session),getUsernameSession(session));
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("{cid}/num/sub")
    private JsonResult<Integer> subNum(@PathVariable("cid")Integer cid,HttpSession session){
        Integer data = cartService.subNum(cid,getUidFromSession(session),getUsernameSession(session));
        return new JsonResult<>(OK,data);
    }


    @RequestMapping("list")
    private JsonResult<List<CartVO>> getVOByCid(Integer[] cids,HttpSession session){
        List<CartVO> data = cartService.getVOByCid(getUidFromSession(session),cids);
        return new JsonResult<>(OK,data);
    }



}
