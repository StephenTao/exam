package com.augmentum.exam.dto;

import java.util.Date;
import java.util.List;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class QuestionDTO {

    private int id;
    @NotEmpty
    @NotNull
    @Length(max = 15)
    private String code;
    @NotEmpty
    @NotNull
    @Length(max = 6000)
    private String title;
    @NotEmpty
    @NotNull
    @Length(max = 6000)
    private String titleText;
    private String answer;
    private int questionTypeId;
    private Date createdTime;
    private Date updatedTime;
    private String status;
    private String author;
    private int authorId;
    private int parentId;
    private List<QuestionOptionDTO> options;
    private List<TagDTO> tags;

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

    public List<QuestionOptionDTO> getOptions() {
        return options;
    }

    public void setOptions(List<QuestionOptionDTO> options) {
        this.options = options;
    }

    public List<TagDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagDTO> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("QuestionDTO [id=");
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
        builder.append(", options=");
        builder.append(options);
        builder.append(", tags=");
        builder.append(tags);
        builder.append("]");
        return builder.toString();
    }

}
