package com.augmentum.exam.model;

public class UserShowField {

    private int userId;
    private int showFieldId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getShowFieldId() {
        return showFieldId;
    }

    public void setShowFieldId(int showFieldId) {
        this.showFieldId = showFieldId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserShowField [userId=");
        builder.append(userId);
        builder.append(", showFieldId=");
        builder.append(showFieldId);
        builder.append("]");
        return builder.toString();
    }
}
