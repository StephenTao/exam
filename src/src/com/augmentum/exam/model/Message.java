package com.augmentum.exam.model;

import java.util.Date;

public class Message {

    private int id;
    private String title;
    private int messageTypeId;
    private Date createdTime;
    private int entityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMessageTypeId() {
        return messageTypeId;
    }

    public void setMessageTypeId(int messageTypeId) {
        this.messageTypeId = messageTypeId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Message [messageTypeId=");
        builder.append(messageTypeId);
        builder.append(", createdTime=");
        builder.append(createdTime);
        builder.append(", entityId=");
        builder.append(entityId);
        builder.append(", title=");
        builder.append(title);
        builder.append(", id=");
        builder.append(id);
        builder.append("]");
        return builder.toString();
    }
}
