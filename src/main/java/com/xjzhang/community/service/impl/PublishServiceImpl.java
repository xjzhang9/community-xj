package com.xjzhang.community.service.impl;

import com.xjzhang.community.dao.QuestionMapper;
import com.xjzhang.community.dao.UserMapper;
import com.xjzhang.community.entry.dto.QuestionDto;
import com.xjzhang.community.entry.model.Question;
import com.xjzhang.community.service.IPublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 服务处理实现类
 * @author xjzhang
 * @version 1.0
 * @date 2020/5/29 21:30
 */
@Service
public class PublishServiceImpl implements IPublishService {
    /**
     * 用户mapper
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 问题mapper
     */
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public void create(Question question) {
        question.setCreateDate(System.currentTimeMillis());
        question.setLastModifyDate(System.currentTimeMillis());
        questionMapper.create(question);
    }

    @Override
    public List<QuestionDto> selectQuestion() {
        return questionMapper.selectQuestion();
    }
}
