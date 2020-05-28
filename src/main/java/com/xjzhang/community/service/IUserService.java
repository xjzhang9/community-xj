package com.xjzhang.community.service;

import com.xjzhang.community.entry.dto.UserInfoDto;
import com.xjzhang.community.entry.model.UserModel;
import org.springframework.stereotype.Service;

/**
 * @author xjzhang
 * @version 1.0
 * @date 2020/5/27 17:49
 *  用戶信息處理服務
 */
public interface IUserService {
    /**
     * 插入用戶信息
     * @param userInfoDto 用戶信息
     * @return 返回插入條數
     */
    int insertUser(UserInfoDto userInfoDto);

    /**
     * 根據token查詢用戶信息
     * @param token
     * @return 返回用戶信息
     */
    UserInfoDto selectUserByToken(String token);
}
