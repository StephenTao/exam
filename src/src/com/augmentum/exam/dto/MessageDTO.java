package com.augmentum.exam.dto;

import java.util.Date;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class MessageDTO {

    private int id;
    private int messageTypeId;
    @NotNull
    @NotEmpty
    @Length(max = 1000)
    private String title;
    private Date createdTime;
    private int entityId;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MessageDTO [messageTypeId=");
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
