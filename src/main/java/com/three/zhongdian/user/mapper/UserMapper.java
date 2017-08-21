package com.three.zhongdian.user.mapper;

import com.three.zhongdian.user.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/8/5.
 */
@Mapper
@Repository
public interface UserMapper {
    /*
    登陆的方法
     */
    @Select("select * from user where (username=#{username} or mail=#{username} or phone=#{username}) and password=#{password}")
    List<User> login(User user);
    /*
    用户注册的方法
     */
    @Insert("insert into user(nickname,phone,password) values (#{nickname},#{phone},#{password})")
    void saveUser(User user);
    /*
    用户修改的方法
     */
    @Update("update user set nickname=#{nickname},username=#{username},gender=#{gender},birthday=#{birthday},intro=#{intro},province=#{province},city=#{city} where id=#{id} ")
    void updateUser(User user);
    /*
    根据id查询用户
     */
    @Select("select * from user where id=#{id}")
    User findUserById(Integer id);
    /*
    修改头像的方法
     */
    @Update("update user set imgHead=#{imgHead} where id=#{id}")
    void updateImgHead(User user);

}
