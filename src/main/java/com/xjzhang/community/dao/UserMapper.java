package com.xjzhang.community.dao;

import com.xjzhang.community.entry.dto.UserInfoDto;
import com.xjzhang.community.entry.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xjzhang
 */
@Mapper
public interface UserMapper {
        /**
         * 插入用户信息
         * @param userInfoDto
         * @return
         */
        int insertUser(UserInfoDto userInfoDto);

        /**
         * 根据token查询用户信息
         * @param token
         * @return
         */
        UserModel selectUserByToken(String token);
}
