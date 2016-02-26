package com.augmentum.exam.dto;

import java.util.Date;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class UserMessageDTO {

    private int id;
    @Length(max = 10)
    private int messageTypeId;
    @NotNull
    @NotEmpty
    @Length(max = 1000)
    private String title;
    private Date receivedTime;
    @Length(max = 10)
    private int fromUserId;
    @Length(max = 500)
    private String url;
    @Length(max = 10)
    private int messageId;
    @Length(max = 10)
    private int toUserId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }

    public int getMessageTypeId() {
        return messageTypeId;
    }

    public void setMessageTypeId(int messageTypeId) {
        this.messageTypeId = messageTypeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(Date receivedTime) {
        this.receivedTime = receivedTime;
    }

    public int getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserMessageDTO [id=");
        builder.append(id);
        builder.append(", messageTypeId=");
        builder.append(messageTypeId);
        builder.append(", title=");
        builder.append(title);
        builder.append(", receivedTime=");
        builder.append(receivedTime);
        builder.append(", fromUserId=");
        builder.append(fromUserId);
        builder.append(", url=");
        builder.append(url);
        builder.append(", messageId=");
        builder.append(messageId);
        builder.append(", toUserId=");
        builder.append("]");
        return builder.toString();
    }
}
