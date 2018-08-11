package com.francis.speeroad.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.francis.speeroad.entity.EMUser;

/**
 * em user dao
 *
 * @author hzzhugequn
 * @date 2018/8/5
 * @since JDK 1.8
 */
@Mapper
public interface EMUserDao {
    String TABLE_NAME = "em_user";
    String INSERT_FIELDS = "username, password, nickname, uuid, type, created, modified, activated";
    String SELECT_FIELDS = "id," + INSERT_FIELDS;

    /**
     * 新增用户
     *
     * @param user 用户信息
     */
    @Insert({" insert into ", TABLE_NAME, " ( ", INSERT_FIELDS, " )values(#{user.username}, #{user.password}, #{user.nickname}, #{user.uuid}, #{user.type}, #{user.created}, #{user.modified}, #{user.activated}) "})
    void addUser(@Param("user") EMUser user);

    /**
     * 根据用户名查找
     *
     * @param username 用户名
     * @return 用户
     */
    @Select({" select ", SELECT_FIELDS, " from ", TABLE_NAME, " where username=#{username} "})
    EMUser getUser(@Param("username") String username);
}
