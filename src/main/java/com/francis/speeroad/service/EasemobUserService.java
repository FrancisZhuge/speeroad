package com.francis.speeroad.service;

import java.util.List;

import com.francis.speeroad.entity.EaseMobUser;
import com.francis.speeroad.exception.BaseException;

/**
 * 环信 服务类
 *
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
public interface EasemobUserService {

    /**
     * 在em中注册
     *
     * @throws BaseException
     */
    EaseMobUser registerSingle(String username, String password, String nickname) throws BaseException;

    /**
     * 从em中获取
     *
     * @param username 用户名
     * @return
     * @throws BaseException
     */
    EaseMobUser getSingle(String username) throws BaseException;

    /**
     * 从em中删除
     *
     * @param username 用户名
     * @return
     * @throws BaseException
     */
    EaseMobUser delSingle(String username) throws BaseException;

    /**
     * 修改密码
     *
     * @param username 用户名
     * @param password 密码
     * @return
     * @throws BaseException 失败
     */
    EaseMobUser resetSingle(String username, String password) throws BaseException;

    /**
     * 修改昵称
     *
     * @param username 用户名
     * @param nickname 新昵称
     * @return
     * @throws BaseException
     */
    EaseMobUser resetNickname(String username, String nickname) throws BaseException;

    /**
     * 添加好友
     *
     * @param ownerUsername  主
     * @param friendUsername 朋友
     * @return friendUsername 的信息
     * @throws BaseException
     */
    EaseMobUser addFriend(String ownerUsername, String friendUsername) throws BaseException;

    /**
     * 删除好友
     *
     * @param ownerUsername  主
     * @param friendUsername 朋友
     * @return friendUsername 的信息
     * @throws BaseException
     */
    EaseMobUser delFriend(String ownerUsername, String friendUsername) throws BaseException;

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
     * @param username 用户名
     * @return
     * @throws BaseException
     */
    Long getOfflineCounts(String username) throws BaseException;

    /**
     * 查询离线消息状况
     *
     * @param username   用户名
     * @param message_id 消息主键
     * @return {@code true} 收到过了， {@code false} 没有收到过
     * @throws BaseException
     */
    Boolean getOfflineStatus(String username, long message_id) throws BaseException;

    /**
     * 禁用用户
     *
     * @param username 用户名
     * @return
     * @throws BaseException
     */
    EaseMobUser deactivate(String username) throws BaseException;

    /**
     * 解禁用户
     *
     * @param username
     * @return
     * @throws BaseException
     */
    EaseMobUser activate(String username) throws BaseException;

    /**
     * 强制用户下线
     *
     * @param username
     * @return
     * @throws BaseException
     */
    Boolean disConnect(String username) throws BaseException;
}
