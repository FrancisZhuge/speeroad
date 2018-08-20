package com.francis.speeroad.dao;

import com.francis.speeroad.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author francis
 * @className
 * @date 2018/8/12
 * @see
 * @since JDK 1.8
 */
@Mapper
public interface UserDao {
    String TABLE_NAME = "ease_user";
    String INSERT_FIELDS = "username, password, ease_password, salt, uuid, create_time, modify_time, device_token, active, nickname";
    String SELECT_FIELDS = "id, " + INSERT_FIELDS;

    @Insert({" insert into ", TABLE_NAME ," ( " ,INSERT_FIELDS, " )values(#{user.username}, #{user.password}, #{user.easePassword}, #{user.salt}, #{user.uuid}, #{user.createTime}, #{user.modifyTime}, #{user.deviceToken}, #{user.active}, #{user.nickname}) "})
    @Options(useGeneratedKeys = true,keyProperty = "user.id")
    void addUser(@Param("user") User user);

    @Select({" select ", SELECT_FIELDS ," from ", TABLE_NAME ," where id=#{id} "})
    User getUserById(@Param("id") long id);

    @Select({" select ", SELECT_FIELDS ," from ", TABLE_NAME ," where username=#{username} "})
    User getUserByUsername(@Param("username") String username);

}
