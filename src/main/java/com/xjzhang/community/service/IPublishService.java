package com.xjzhang.community.service;

import com.xjzhang.community.entry.dto.QuestionDto;
import com.xjzhang.community.entry.model.Question;
import java.util.List;

/**
 * 问题处理服务
 * @author xjzhang
 * @version 1.0
 * @date 2020/5/29 21:29
 */
public interface IPublishService {
    /**
     * 创建发布问题
     * @param question 问题内容
     */
     void create(Question question);

    /**
     * 查询问题列表
     * @return
     */
     List<QuestionDto> selectQuestion();
}
