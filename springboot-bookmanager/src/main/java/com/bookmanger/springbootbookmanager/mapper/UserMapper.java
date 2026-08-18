package com.bookmanger.springbootbookmanager.mapper;


import com.bookmanger.springbootbookmanager.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
        @Insert("INSERT INTO `user` (username,password) VALUES (#{username},#{password})")
        void register(User user);

        @Select("SELECT * FROM `user` WHERE username = #{username}")
        User findByUsername(String username);

        @Select("SELECT * FROM `user`")
        List<User> queryAll();

        @Select("SELECT * FROM `user` WHERE id = #{id}")
        User queryById(int id);

        @Update("UPDATE `user` SET username = #{username}, password = #{password} WHERE id = #{id}")
        int updateUser(User user);

        @Delete("DELETE FROM `user` WHERE id = #{id}")
        int deleteUser(int id);
}
