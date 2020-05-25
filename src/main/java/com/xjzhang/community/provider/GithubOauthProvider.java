package com.xjzhang.community.provider;

import com.alibaba.fastjson.JSON;
import com.xjzhang.community.entry.dto.GithubOauthDto;
import com.xjzhang.community.utils.HttpUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class GithubOauthProvider {
    public String getAccessToken(GithubOauthDto githubOauthDto) throws IOException {
        String body = HttpUtil.post("https://github.com/login/oauth/access_token", JSON.toJSONString(githubOauthDto));
        return body;
    }

    public String getUserInfo(String accessToken) throws IOException {
        String body =HttpUtil.get("https://api.github.com/user?access_token=" + accessToken);
        return body;
    }
}
