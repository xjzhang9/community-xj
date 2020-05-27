package com.xjzhang.community.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.xjzhang.community.entry.dto.GithubOauthDto;
import com.xjzhang.community.entry.dto.GithubOauthUserDto;
import com.xjzhang.community.provider.GithubOauthProvider;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author xjzhang
 * @data 2020/05/27
 */
@Controller
public class OauthController {
    private static Logger logger = Logger.getLogger(OauthController.class.getClass());

    @Autowired
    private GithubOauthProvider githubOauthProvider;

    @Value("${github.client.id}")
    private String client_id;

    @Value("${github.client.secret}")
    private String client_secret;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state, HttpServletRequest req) throws IOException {
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

        }
        // 设置session供前端检查登录状态
        HttpSession session = req.getSession();
        session.setAttribute("userinfo", );

        return "redirect:/";
    }

}
