package com.bookmanger.springbootbookmanager.mapper;


import com.bookmanger.springbootbookmanager.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
        @Insert("INSERT INTO `user` (username,password) VALUES (#{username},#{password})")
        void register(User user);

        @Select("SELECT * FROM `user` WHERE username = #{username}")
        User findByUsername(String username);
}
