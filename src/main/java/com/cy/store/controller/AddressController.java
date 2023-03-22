package com.cy.store.controller;

import com.cy.store.entity.Address;
import com.cy.store.service.IAddressService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.lang.annotation.Retention;
import java.net.Inet4Address;
import java.util.List;

@RequestMapping("addresses")
@RestController
public class AddressController extends BaseController{
    @Autowired
    private IAddressService addressService;

    @RequestMapping("add_new_address")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameSession(session);
        addressService.addNewAddress(uid,username,address);
        return  new JsonResult<>(OK);

    }

    @RequestMapping({"","/"})
    public  JsonResult<List<Address>> getByUid(HttpSession session){
        Integer uid = getUidFromSession(session);
        List<Address> data = addressService.getByUid(uid);
        return new JsonResult<>(OK,data);
    }

    //RestFul风格的请求编写
    @RequestMapping("{aid}/set_default")
    public JsonResult<Void> setDefault(@PathVariable("aid") Integer aid,
                                       HttpSession session){
        addressService.setDefault(aid,
                getUidFromSession(session),getUsernameSession(session));
        return  new JsonResult<>(OK);
    }

    @RequestMapping("{aid}/delete")
    public JsonResult<Void> delete(@PathVariable("aid") Integer aid,HttpSession sessions){
        addressService.delete(aid,getUidFromSession(sessions),getUsernameSession(sessions));
        return new JsonResult<>(OK);
    }
}
