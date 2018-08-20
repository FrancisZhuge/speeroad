package com.francis.speeroad.dao;

import com.francis.speeroad.entity.Token;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author francis
 * @className
 * @date 2018/8/13
 * @see
 * @since JDK 1.8
 */
@Mapper
public interface TokenDao {
    String TABLE_NAME = "ease_token";
    String INSERT_FIELDS = "user_id, token, expired, status";
    String SELECT_FIELDS = "id, " + INSERT_FIELDS;

    @Insert({" insert into ", TABLE_NAME, " ( ", INSERT_FIELDS, " )values(#{token.userId}, #{token.token}, #{token.expired}, #{token.status}) "})
    @Options(useGeneratedKeys = true, keyProperty = "token.id")
    void addToken(@Param("token") Token token);

    @Select({" select ", SELECT_FIELDS, " from ", TABLE_NAME, " where token=#{token} "})
    Token getTokenByToken(@Param("token") String token);

    @Update({"update ", TABLE_NAME, " set status=#{status} where token=#{token}"})
    void updateStatus(@Param("token") String token, @Param("status") boolean status);

}
