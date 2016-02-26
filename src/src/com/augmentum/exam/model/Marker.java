package com.augmentum.exam.model;

public class Marker {

    private int examId;
    private int userId;

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Marker [examId=");
        builder.append(examId);
        builder.append(", userId=");
        builder.append(userId);
        builder.append("]");
        return builder.toString();
    }
}
