package com.xjzhang.community.provider;

import com.xjzhang.community.entry.model.User;
import com.xjzhang.community.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author xjzhang
 * @version 1.0
 * @date 2020/5/30 19:33
 */
@Component
public class UserProvider {
    @Autowired
    private IUserService userService;
    /**
     * 获得用户信息，根据cookies
     *
     * @param req
     * @return 返回用户信息
     */
    public User getUserInfo(HttpServletRequest req) {
        User user = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if ("token".equals(cookieName)) {
                    String token = cookie.getValue();
                    user = userService.selectUserByToken(token);
                }
            }
        }
        return user;
    }

    /**
     * 判断用户是否登陆
     *
     * @param req
     * @return
     */
    public boolean isLogin(HttpServletRequest req) {
        if (getUserInfo(req) == null) {
            return false;
        }
        return true;
    }
}
