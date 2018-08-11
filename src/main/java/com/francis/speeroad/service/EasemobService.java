package com.francis.speeroad.service;

import java.util.List;

import com.francis.speeroad.entity.EMUser;
import com.francis.speeroad.exception.BaseException;

/**
 * 环信 服务类
 *
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
public interface EasemobService {

    /**
     * 在em中注册
     *
     * @throws BaseException
     */
    EMUser registerSingle(String username, String password, String nickname) throws BaseException;

    /**
     * 从em中获取
     *
     * @param username 用户名
     * @return
     * @throws BaseException
     */
    EMUser getSingle(String username) throws BaseException;

    /**
     * 从em中删除
     *
     * @param username 用户名
     * @return
     * @throws BaseException
     */
    EMUser delSingle(String username) throws BaseException;

    /**
     * 修改密码
     *
     * @param username 用户名
     * @param password 密码
     * @return
     * @throws BaseException 失败
     */
    EMUser resetSingle(String username, String password) throws BaseException;

    /**
     * 修改昵称
     *
     * @param username 用户名
     * @param nickname 新昵称
     * @return
     * @throws BaseException
     */
    EMUser resetNickname(String username, String nickname) throws BaseException;

    /**
     * 添加好友
     *
     * @param ownerUsername  主
     * @param friendUsername 朋友
     * @return friendUsername 的信息
     * @throws BaseException
     */
    EMUser addFriend(String ownerUsername, String friendUsername) throws BaseException;

    /**
     * 删除好友
     *
     * @param ownerUsername  主
     * @param friendUsername 朋友
     * @return friendUsername 的信息
     * @throws BaseException
     */
    EMUser delFriend(String ownerUsername, String friendUsername) throws BaseException;

    /**
     * 获取好友列表
     *
     * @param username 用户名
     * @return
     * @throws BaseException
     */
    List<String> getFriend(String username) throws BaseException;

    /**
     * 获取用户是否在线
     *
     * @param username 用户名
     * @return {@code true}在线，{@code false} 下线
     * @throws BaseException
     */
    Boolean getStatus(String username) throws BaseException;

    /**
     * 查询离线消息数
     *
     * @param usernmae 用户名
     * @return
     * @throws BaseException
     */
    Long getOfflineCounts(String usernmae) throws BaseException;

    /**
     * 查询离线消息状况
     *
     * @param message_id 消息主键
     * @return {@code true} 收到过了， {@code false} 没有收到过
     * @throws BaseException
     */
    Boolean getOfflineStatus(String message_id) throws BaseException;

    /**
     * 禁用用户
     *
     * @param username 用户名
     * @return
     * @throws BaseException
     */
    EMUser Deactivate(String username) throws BaseException;

    /**
     * 解禁用户
     *
     * @param username
     * @return
     * @throws BaseException
     */
    Boolean Activate(String username) throws BaseException;

    /**
     * 强制用户下线
     *
     * @param username
     * @return
     * @throws BaseException
     */
    Boolean disConnect(String username) throws BaseException;
}
