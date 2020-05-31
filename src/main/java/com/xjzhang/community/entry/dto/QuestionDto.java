package com.xjzhang.community.entry.dto;

import com.xjzhang.community.entry.model.Question;
import com.xjzhang.community.entry.model.User;

/**
 * @author xjzhang
 */
public class QuestionDto extends Question {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "QuestionDto{" +
                "user=" + user +
                '}';
    }
}
