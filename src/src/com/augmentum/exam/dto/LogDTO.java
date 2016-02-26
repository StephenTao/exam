package com.augmentum.exam.dto;

import java.util.Date;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class LogDTO {

    private int id;
    private int entityId;
    @NotNull
    @NotEmpty
    private String entityType;
    private Date createdTime;
    private int userId;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LogHistory [id=");
        builder.append(id);
        builder.append(", entityId=");
        builder.append(entityId);
        builder.append(", entityType=");
        builder.append(entityType);
        builder.append(", createdTime=");
        builder.append(createdTime);
        builder.append(", userId=");
        builder.append(userId);
        builder.append(", content=");
        builder.append(content);
        builder.append("]");
        return builder.toString();
    }
}
