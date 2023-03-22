package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 用户模块的接口
 */
public interface UserMapper {
    /**
     * 插入用户的数据
     * @param user 用户的收据
     * @return 影响的行数（根据返回值判断是否成功）
     */
    Integer insert(User user);

    /**
     * 根据用户名来查询用户的数据
     * @param username 用户名
     * @return 如果找到用户则返回用户的数据，没有则返回null值
     */
    User findByUsername(String username);


    /**
     * 根据用户的uid来修改用户密码
     * @param uid 用户的uid
     * @param modifiedUser  表示修改的执行者
     * @param modifiedTime 表示修改数据的时间
     * @return 返回值为受影响的行数
     */
    Integer updatePasswordByUid(Integer uid, String password,
                                String modifiedUser, Date modifiedTime);

    /**
     * 根据用户的id查询用户的数据
     * @param uid 用户的id
     * @return 如果找到则返回对象，反之返回null
     */
    User findByUid(Integer uid);


    /**
     * 更新用户的数据信息
     * @param user 用户的数据
     * @return 返回值为受影响的行数
     */
    Integer updateInfoByUid(User user);

    /**
     * @param("sql映射文件中#{}中的占位符")，解决的问题，当sql语句的占位符和映射的接口方法参数名不一致时，需要将某个参数强行注入
     * 到某个变量上时，可以使用@param这个注解来标注映射的关系
     * 根据用户的uid修改用户的头像
     * @param uid
     * @param avatar
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer updateAvatarByUid(@Param("uid") Integer uid,
                              @Param("avatar")String avatar,
                              @Param("modifiedUser")String modifiedUser,
                              @Param("modifiedTime") Date modifiedTime);
}
