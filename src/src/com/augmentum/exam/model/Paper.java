package com.augmentum.exam.model;

import java.util.Date;

public class Paper {

    private int id;
    private String code;
    private String name;
    private int adviceDuration;
    private String description;
    private int creatorId;
    private Date createdTime;
    private String status;
    private double totalScore;
    private int totalQuestion;
    private int referPaperId;
    private int shadowOf;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAdviceDuration() {
        return adviceDuration;
    }

    public void setAdviceDuration(int adviceDuration) {
        this.adviceDuration = adviceDuration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(int totalQuestion) {
        this.totalQuestion = totalQuestion;
    }

    public int getReferPaperId() {
        return referPaperId;
    }

    public void setReferPaperId(int referPaperId) {
        this.referPaperId = referPaperId;
    }

    public int getShadowOf() {
        return shadowOf;
    }

    public void setShadowOf(int shadowOf) {
        this.shadowOf = shadowOf;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Paper [id=");
        builder.append(id);
        builder.append(", code=");
        builder.append(code);
        builder.append(", name=");
        builder.append(name);
        builder.append(", adviceDuration=");
        builder.append(adviceDuration);
        builder.append(", description=");
        builder.append(description);
        builder.append(", creatorId=");
        builder.append(creatorId);
        builder.append(", createdTime=");
        builder.append(createdTime);
        builder.append(", status=");
        builder.append(status);
        builder.append(", totalScore=");
        builder.append(totalScore);
        builder.append(", totalQuestion=");
        builder.append(totalQuestion);
        builder.append(", referPaperId=");
        builder.append(referPaperId);
        builder.append(", shadowOf=");
        builder.append(shadowOf);
        builder.append("]");
        return builder.toString();
    }

}
