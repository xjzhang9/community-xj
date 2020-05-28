package com.xjzhang.community.entry.dto;

import com.xjzhang.community.entry.model.UserModel;

/**
 * 用户信息传输
 * @author xjzhang
 * @version 1.0
 * @date 2020/5/27 17:55
 */
public class UserInfoDto {
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
     * 创建时间
     */
    protected String createDate;

    /**
     * 最后修改时间
     */
    private String lastModifyDate;

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
