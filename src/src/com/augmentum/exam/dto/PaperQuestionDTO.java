package com.augmentum.exam.dto;

import java.util.Date;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class PaperQuestionDTO {

    private int id;
    @NotEmpty
    @NotNull
    @Length(max = 6000)
    private String title;
    @NotEmpty
    @NotNull
    @Length(max = 6000)
    private String titleText;
    @Length(max = 6000)
    private String answer;
    @NotNull
    private int questionTypeId;
    private String source;
    private Date createdTime;
    private int authorId;
    private int parentId;
    @NotNull
    private int order;
    @NotNull
    private double score;
    private int referQuestionId;
    @NotNull
    private int paperPartId;

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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getReferQuestionId() {
        return referQuestionId;
    }

    public void setReferQuestionId(int referQuestionId) {
        this.referQuestionId = referQuestionId;
    }

    public int getPaperPartId() {
        return paperPartId;
    }

    public void setPaperPartId(int paperPartId) {
        this.paperPartId = paperPartId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PaperQuestionDTO [id=");
        builder.append(id);
        builder.append(", title=");
        builder.append(title);
        builder.append(", titleText=");
        builder.append(titleText);
        builder.append(", answer=");
        builder.append(answer);
        builder.append(", questionTypeId=");
        builder.append(questionTypeId);
        builder.append(", source=");
        builder.append(source);
        builder.append(", createdTime=");
        builder.append(createdTime);
        builder.append(", authorId=");
        builder.append(authorId);
        builder.append(", parentId=");
        builder.append(parentId);
        builder.append(", order=");
        builder.append(order);
        builder.append(", score=");
        builder.append(score);
        builder.append(", referQuestionId=");
        builder.append(referQuestionId);
        builder.append(", paperPartId=");
        builder.append(paperPartId);
        builder.append("]");
        return builder.toString();
    }

}
