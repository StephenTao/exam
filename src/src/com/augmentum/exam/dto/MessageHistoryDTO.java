package com.augmentum.exam.dto;

import java.util.Date;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class MessageHistoryDTO {

    private int id;
    private int entityId;
    @NotNull
    private Date createdTime;
    @NotNull
    @NotEmpty
    @Length(max = 1000)
    private String title;
    private int messageTypeId;

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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMessageTypeId() {
        return messageTypeId;
    }

    public void setMessageTypeId(int messageTypeId) {
        this.messageTypeId = messageTypeId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MessageHistory [id=");
        builder.append(id);
        builder.append(", entityId=");
        builder.append(entityId);
        builder.append(", createdTime=");
        builder.append(createdTime);
        builder.append(", title=");
        builder.append(title);
        builder.append(", messageTypeId=");
        builder.append(messageTypeId);
        builder.append("]");
        return builder.toString();
    }
}
