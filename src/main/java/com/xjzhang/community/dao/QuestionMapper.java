package com.xjzhang.community.dao;

import com.xjzhang.community.entry.dto.QuestionDto;
import com.xjzhang.community.entry.model.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xjzhang
 */
@Mapper
public interface QuestionMapper {
    /**
     * 创建问题
     *
     * @param question
     */
    void create(Question question);

    /**
     * 查询问题列表
     *
     * @return
     */
    List<QuestionDto> selectQuestion();
}
