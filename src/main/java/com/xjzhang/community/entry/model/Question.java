package com.xjzhang.community.entry.model;

import com.xjzhang.community.entry.dto.QuestionDto;

/**
 * @author xjzhang
 * @version 1.0
 * @date 2020/5/31 15:40
 */
public class Question {
    /**
     * 问题标题
     */
    private String tittle;

    /**
     * 问题描述
     */
    private String description;

    /**
     * 问题创建时间
     */
    private String createDate;

    /**
     * 问题修改时间
     */
    private String lastModifyDate;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 评论数
     */
    private int commitCount;

    /**
     * 浏览量
     */
    private int viewCount;

    /**
     * 关注量
     */
    private int likeCount;

    /**
     * 标签
     */
    private String tag;

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(String lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getCommitCount() {
        return commitCount;
    }

    public void setCommitCount(int commitCount) {
        this.commitCount = commitCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "QuestionDto{" +
                "tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                ", createDate='" + createDate + '\'' +
                ", modifyDate='" + lastModifyDate + '\'' +
                ", createor='" + creator + '\'' +
                ", commitCount=" + commitCount +
                ", viewCount=" + viewCount +
                ", likeCount=" + likeCount +
                ", tag='" + tag + '\'' +
                '}';
    }
}
