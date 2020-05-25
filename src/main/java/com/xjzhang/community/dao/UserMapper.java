package com.xjzhang.community.dao;

import com.xjzhang.community.entry.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
        int insertUser(UserModel userModel);
        UserModel selectUserByAccountId(String accountId);
}
