package com.xjzhang.community.controller;

import com.xjzhang.community.entry.dto.UserInfoDto;
import com.xjzhang.community.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author xjzhang
 * @data 2020/05/27
 */
@Controller
public class IndexController {
    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String index(HttpServletRequest req) {
        Cookie[] cookies =  req.getCookies();
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                String cookieName = cookie.getName();
              if ("token".equals(cookieName)) {
                  String token = cookie.getValue();
                  UserInfoDto userInfoDto = userService.selectUserByToken(token);
                  // 通过session返回用户信息，前端展示
                  req.getSession().setAttribute("userinfo", userInfoDto);
              }
            }
        }
        return "index";
    }
}
