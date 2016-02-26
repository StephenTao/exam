package com.augmentum.exam.dto;

import java.util.Date;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class QuestionCommentDTO {

    private int id;
    @NotEmpty
    @NotNull
    private int userId;
    @NotEmpty
    @NotNull
    private int questionId;
    @NotEmpty
    @NotNull
    @Length(max = 1000)
    private String content;
    private Date createdTime;
    private int referId;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public int getReferId() {
        return referId;
    }

    public void setReferId(int referId) {
        this.referId = referId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("QuestionCommentDTO [id=");
        builder.append(id);
        builder.append(", userId=");
        builder.append(userId);
        builder.append(", questionId=");
        builder.append(questionId);
        builder.append(", content=");
        builder.append(content);
        builder.append(", createdTime=");
        builder.append(createdTime);
        builder.append(", referId=");
        builder.append(referId);
        builder.append(", status=");
        builder.append(status);
        builder.append("]");
        return builder.toString();
    }

}
