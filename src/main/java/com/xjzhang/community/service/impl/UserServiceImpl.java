package com.xjzhang.community.service.impl;

import com.xjzhang.community.dao.UserMapper;
import com.xjzhang.community.entry.dto.UserInfoDto;
import com.xjzhang.community.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xjzhang
 * @version 1.0
 * @date 2020/5/27 17:53
 */
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper mUserMapper;

    @Override
    public int insertUser(UserInfoDto userInfoDto) {
        return mUserMapper.insertUser(userInfoDto);
    }

    @Override
    public UserInfoDto selectUserByToken(String token) {
        return (UserInfoDto) mUserMapper.selectUserByToken(token);

    }
}
