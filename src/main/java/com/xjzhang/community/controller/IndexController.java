package com.xjzhang.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xjzhang.community.entry.dto.QuestionDto;
import com.xjzhang.community.entry.model.User;
import com.xjzhang.community.service.IPublishService;
import com.xjzhang.community.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author xjzhang
 * @data 2020/05/27
 */
@Controller
public class IndexController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IPublishService publishService;

    private static int startPage = 1;
    private  static int endPage = 5;

    @GetMapping("/")
    public String index(@RequestParam(name = "pageIndex", defaultValue = "1") int pageIndex, @RequestParam(name = "pageSize", defaultValue = "10") int pageSize, @RequestParam(name = "prev", defaultValue = "false") boolean prev, @RequestParam(name = "next", defaultValue = "false") boolean next, HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if ("token".equals(cookieName)) {
                    String token = cookie.getValue();
                    User user = userService.selectUserByToken(token);
                    // 通过session返回用户信息，前端展示
                    HttpSession httpSession = req.getSession();
                    httpSession.setAttribute("userinfo", user);
                    if (user != null) {
                        //  创建Page对象，将page，limit参数传入，必须位于从数据库查询数据的语句之前，否则不生效
                        PageHelper.startPage(pageIndex, pageSize);
                        List<QuestionDto> questionDtoList = publishService.selectQuestion();
                        PageInfo<QuestionDto> questionDtoPageInfo = new PageInfo<>(questionDtoList);

                        httpSession.setAttribute("questions", questionDtoPageInfo);



                        httpSession.setAttribute("startPage", startPage);
                        httpSession.setAttribute("endPage", endPage);

                        if (prev & startPage > 1) {
                            httpSession.setAttribute("startPage", startPage - 1);
                            httpSession.setAttribute("endPage", endPage - 1);
                        }

                        if (next && endPage < questionDtoPageInfo.getPages()) {
                            httpSession.setAttribute("startPage", startPage + 1);
                            httpSession.setAttribute("endPage", endPage + 1);
                        }
                    }
                }
            }
        }

        return "index";
    }
}
