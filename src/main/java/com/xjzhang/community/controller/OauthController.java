package com.xjzhang.community.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.xjzhang.community.entry.dto.GithubOauthDto;
import com.xjzhang.community.entry.dto.GithubOauthUserDto;
import com.xjzhang.community.entry.model.User;
import com.xjzhang.community.provider.GithubOauthProvider;
import com.xjzhang.community.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author xjzhang
 * @data 2020/05/27
 */
@Controller
public class OauthController {
    private static Logger logger = Logger.getLogger(OauthController.class.getClass());

    @Autowired
    private GithubOauthProvider githubOauthProvider;

    @Autowired
    private IUserService userService;

    @Value("${github.client.id}")
    private String client_id;

    @Value("${github.client.secret}")
    private String client_secret;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state, HttpServletRequest req, HttpServletResponse rep) throws IOException {
        GithubOauthDto githubOauthDto = new GithubOauthDto();
        githubOauthDto.setCode(code);
        githubOauthDto.setState(state);
        githubOauthDto.setClient_id(client_id);
        githubOauthDto.setClient_secret(client_secret);
        githubOauthDto.setState(state);

        String body = githubOauthProvider.getAccessToken(githubOauthDto);
        String[] bodys = body.split("&");
        String accessToken = bodys[0].split("=")[1];

        String userInfo = githubOauthProvider.getUserInfo(accessToken);
        logger.info(userInfo);

        GithubOauthUserDto githubOauthUserDto = JSON.parseObject(userInfo, new TypeReference<GithubOauthUserDto>() {});
        if (githubOauthDto != null) {
            User user = new User();
            user.setAccountId(githubOauthUserDto.getId());
            user.setIds(githubOauthUserDto.getBio());
            user.setName(githubOauthUserDto.getName());
            user.setAvatarUrl(githubOauthUserDto.getAvatar_url());
            user.setCreateDate(System.currentTimeMillis() + "");
            user.setLastModifyDate(System.currentTimeMillis() + "");
            user.setToken(UUID.randomUUID()+"");
            userService.insertUser(user);

            Cookie cookie = new Cookie("token", user.getToken());
            rep.addCookie(cookie);
        }

        return "redirect:/";
    }

}
