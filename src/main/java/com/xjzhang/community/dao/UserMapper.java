package com.xjzhang.community.dao;
import com.xjzhang.community.entry.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xjzhang
 */
@Mapper
public interface UserMapper {
        /**
         * 插入用户信息
         * @param user
         * @return
         */
        int insertUser(User user);

        /**
         * 根据token查询用户信息
         * @param token
         * @return
         */
        User selectUserByToken(String token);
}
