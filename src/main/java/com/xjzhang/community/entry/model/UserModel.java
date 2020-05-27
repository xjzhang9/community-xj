package com.xjzhang.community.entry.model;

/**
 * @author xjzhang
 */
public class UserModel {
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
     * 创建时间
     */
    protected String createDate;

    /**
     * 最后修改时间
     */
    private String lastModifyDate;


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
}
