package com.xjzhang.community.entry.model;

/**
 * 用户信息，对应数据库表
 * @author xjzhang
 */
public class User {
    private int id;
    /**
     *  账号
     */
    protected String accountId;

    /**
     *  用户名
     */
    protected String name;

    /**
     * token
     */
    protected String token;

    /**
     * 个人简介
     */
    protected String ids;

    /**
     * 头像
     */
    protected String avatarUrl;

    /**
     * 创建时间
     */
    protected Long createDate;

    /**
     * 最后修改时间
     */
    private Long lastModifyDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Long lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                ", ids='" + ids + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", createDate='" + createDate + '\'' +
                ", lastModifyDate='" + lastModifyDate + '\'' +
                '}';
    }
}
