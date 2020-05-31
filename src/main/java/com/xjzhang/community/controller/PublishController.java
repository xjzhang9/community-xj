package com.xjzhang.community.controller;

import com.xjzhang.community.entry.model.Question;
import com.xjzhang.community.entry.model.User;
import com.xjzhang.community.provider.UserProvider;
import com.xjzhang.community.service.IPublishService;
import com.xjzhang.community.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * 发布问题控制类
 * @author xjzhang
 * @version 1.0
 * @date 2020/5/27 18:31
 */
@Controller
public class PublishController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IPublishService publishService;

    @Autowired
    private UserProvider userProvider;

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    /**
     * 创建问题
     * @param tittle 问题标题
     * @param description 问题描述
     * @param tag 问题标签
     * @return
     */
    @PostMapping("/publish")
     public String doPublish(@RequestParam(name = "tittle", required = false) String tittle, @RequestParam(name = "description", required = false) String description,
                             @RequestParam(name = "tag", required = false)String tag, HttpServletRequest req, Model model) {
        model.addAttribute("tittle", tittle);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);

        User  user = userProvider.getUserInfo(req);

        // TODO 代码需要编写异常处理类进行重构。
        if (user == null) {
            model.addAttribute("error", "用户未登陆");
            return "publish";
        }

        if (StringUtils.isEmpty(tittle)) {
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }

        if (StringUtils.isEmpty(description)) {
            model.addAttribute("error", "问题描述不能为空");
            return "publish";
        }

        if (StringUtils.isEmpty(tag)) {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }

        Question question = new Question();
        question.setTittle(tittle);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getAccountId());

        publishService.create(question);

        return "publish";
     }
}
