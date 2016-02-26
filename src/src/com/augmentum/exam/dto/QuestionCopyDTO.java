package com.augmentum.exam.dto;

import java.util.Date;

import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class QuestionCopyDTO {

    private int id;
    @NotNull
    @NotEmpty
    @MaxLength(15)
    private String code;
    @NotNull
    @NotEmpty
    @MaxLength(6000)
    private String title;
    @NotNull
    @NotEmpty
    @MaxLength(6000)
    private String titleText;
    @NotNull
    @NotEmpty
    @MaxLength(6000)
    private String answer;
    @NotNull
    private int questionTypeId;
    @MaxLength(100)
    private String source;
    @NotNull
    private Date createdTime;
    private Date updatedTime;
    @NotNull
    private String status;
    @MaxLength(100)
    private String author;
    private int authorId;
    private int parentId;
    private boolean deleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("QuestionCopyDTO [id=");
        builder.append(id);
        builder.append(", code=");
        builder.append(code);
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
        builder.append(", updatedTime=");
        builder.append(updatedTime);
        builder.append(", status=");
        builder.append(status);
        builder.append(", author=");
        builder.append(author);
        builder.append(", authorId=");
        builder.append(authorId);
        builder.append(", parentId=");
        builder.append(parentId);
        builder.append(", deleted=");
        builder.append(deleted);
        builder.append("]");
        return builder.toString();
    }
}
