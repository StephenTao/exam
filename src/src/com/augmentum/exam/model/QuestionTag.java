package com.augmentum.exam.model;

public class QuestionTag {

    private int questionId;
    private int tagId;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
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
        builder.append("QuestionTag [questionId=");
        builder.append(questionId);
        builder.append(", tagId=");
        builder.append(tagId);
        builder.append("]");
        return builder.toString();
    }

}
