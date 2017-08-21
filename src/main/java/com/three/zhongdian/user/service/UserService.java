package com.three.zhongdian.user.service;

import com.three.zhongdian.user.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by admin on 2017/8/5.
 */
public interface UserService {
    /*
    登陆的方法
     */
    User login(User user);
    /*
    用户注册的方法
     */
    void saveUser(User user);
    /*
    用户修改的方法
     */
    void updateUser(User user);
    /*
    根据id查询用户
     */
    User findUserById(Integer id);
    /*
    修改头像的方法
     */
    void updateImgHead(User user);
}
