package com.augmentum.exam.dto;

import java.util.Date;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class UserAPIDTO {

    private int id;
    @Length(max = 10)
    @NotNull
    private int userId;
    @NotNull
    @NotEmpty
    @Length(max = 100)
    private String appName;
    @NotNull
    @Length(max = 10)
    private int apiId;
    @NotNull
    @Length(max = 45)
    @NotEmpty
    private String ip;
    @Length(max = 1000)
    private String key;
    @NotNull
    @Length(max = 2000)
    @NotEmpty
    private String reason;
    private Date createdTime;
    @Length(max = 2000)
    private String comment;
    @NotNull
    @NotEmpty
    private String status;
    @NotNull
    @Length(max = 45)
    @NotEmpty
    private String phone;
    @NotNull
    @NotEmpty
    @Length(max = 45)
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserApi [id=");
        builder.append(id);
        builder.append(", userId=");
        builder.append(userId);
        builder.append(", appName=");
        builder.append(appName);
        builder.append(", apiId=");
        builder.append(apiId);
        builder.append(", ip=");
        builder.append(ip);
        builder.append(", key=");
        builder.append(key);
        builder.append(", reason=");
        builder.append(reason);
        builder.append(", createdTime=");
        builder.append(createdTime);
        builder.append(", comment=");
        builder.append(comment);
        builder.append(", phone=");
        builder.append(phone);
        builder.append(", email=");
        builder.append(email);
        builder.append(", status=");
        builder.append(status);
        builder.append("]");
        return builder.toString();
    }
}
