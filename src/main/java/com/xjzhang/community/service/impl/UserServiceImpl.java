package com.xjzhang.community.service.impl;

import com.xjzhang.community.dao.UserMapper;
import com.xjzhang.community.entry.model.User;
import com.xjzhang.community.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author xjzhang
 * @version 1.0
 * @date 2020/5/27 17:53
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser((User) user);
    }

    @Override
    public User selectUserByToken(String token) {
        User user = userMapper.selectUserByToken(token);

        return user;
    }
}
