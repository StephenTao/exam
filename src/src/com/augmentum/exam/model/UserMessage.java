package com.augmentum.exam.model;

import java.util.Date;

public class UserMessage {

    private int id;
    private int messageTypeId;
    private String title;
    private Date receivedTime;
    private int fromUserId;
    private String url;
    private int messageId;
    private int toUserId;

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }

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
        builder.append("UserMessage [id=");
        builder.append(id);
        builder.append(", messageTypeId=");
        builder.append(messageTypeId);
        builder.append(", toUserId=");
        builder.append(toUserId);
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
        builder.append("]");
        return builder.toString();
    }
}
