package com.augmentum.exam.model;

public class UserTag {

    private int userId;
    private int tagId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MapUserTag [userId=");
        builder.append(userId);
        builder.append(", tagId=");
        builder.append(tagId);
        builder.append("]");
        return builder.toString();
    }
}
