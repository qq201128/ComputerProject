package com.cy.store.config;

import com.cy.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理拦截器的注册
 */
@Configuration //加载当前的拦截器并进行注册
public class LoginInterceptorConfigurer  implements WebMvcConfigurer {

    /**
     * 配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建自定义拦截器
        HandlerInterceptor interceptor = new LoginInterceptor();
        //配置白名单：存放在一个list集合中
        List<String> patterns = new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/web/index.html");
        patterns.add("/web/product.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");
//        patterns.add("/users/get_by_uid");
//        patterns.add("/users/change_info");
//        patterns.add("/users/change_avatar");
//        patterns.add("/addresses/add_new_address");
        patterns.add("/districts/**");
        patterns.add("/web/index.html");
        patterns.add("/products/**");



        //完成了拦截器的注册
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(patterns);//表示要拦截的url是什么
    }
}
