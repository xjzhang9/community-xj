package com.xjzhang.community.dao;

import com.xjzhang.community.entry.dto.UserInfoDto;
import com.xjzhang.community.entry.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xjzhang
 */
@Mapper
public interface UserMapper {
        int insertUser(UserInfoDto userInfoDto);

        UserModel selectUserByToken(String token);
}
