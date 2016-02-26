package com.augmentum.exam.model;

public class QuestionOption {

    private int id;
    private String title;
    private String titleText;
    private boolean correct;
    private int questionId;
    private int order;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public boolean getCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("QuestionOption [id=");
        builder.append(id);
        builder.append(", title=");
        builder.append(title);
        builder.append(", titleText=");
        builder.append(titleText);
        builder.append(", correct=");
        builder.append(correct);
        builder.append(", questionId=");
        builder.append(questionId);
        builder.append(", order=");
        builder.append(order);
        builder.append("]");
        return builder.toString();
    }

}
