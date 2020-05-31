package com.xjzhang.community.service;
import com.xjzhang.community.entry.model.User;

/**
 * @author xjzhang
 * @version 1.0
 * @date 2020/5/27 17:49
 *  用戶信息處理服務
 */
public interface IUserService {
    /**
     * 插入用戶信息
     * @param user 用戶信息
     * @return 返回插入條數
     */
    int insertUser(User user);

    /**
     * 根據token查詢用戶信息
     * @param token
     * @return 返回用戶信息
     */
    User selectUserByToken(String token);
}
