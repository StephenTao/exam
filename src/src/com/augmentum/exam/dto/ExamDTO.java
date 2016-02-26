package com.augmentum.exam.dto;

import java.util.Date;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class ExamDTO {

    private int id;
    @Length(max = 6000)
    private String description;
    @NotNull
    @NotEmpty
    @Length(max = 1000)
    private String name;
    @NotNull
    @NotEmpty
    @Length(max = 15)
    private String code;
    @NotNull
    private Date endTime;
    private int duration;
    @NotNull
    private Date startTime;
    private int published;
    private int resultPublished;
    private int attendedCount;
    private int examineeCount;
    private double passRate;
    private int passScore;
    private double average;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public int getResultPublished() {
        return resultPublished;
    }

    public void setResultPublished(int resultPublished) {
        this.resultPublished = resultPublished;
    }

    public int getAttendedCount() {
        return attendedCount;
    }

    public void setAttendedCount(int attendedCount) {
        this.attendedCount = attendedCount;
    }

    public int getExamineeCount() {
        return examineeCount;
    }

    public void setExamineeCount(int examineeCount) {
        this.examineeCount = examineeCount;
    }

    public double getPassRate() {
        return passRate;
    }

    public void setPassRate(double passRate) {
        this.passRate = passRate;
    }

    public int getPassScore() {
        return passScore;
    }

    public void setPassScore(int passScore) {
        this.passScore = passScore;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ExamDTO [id=");
        builder.append(id);
        builder.append(", description=");
        builder.append(description);
        builder.append(", name=");
        builder.append(name);
        builder.append(", code=");
        builder.append(code);
        builder.append(", endTime=");
        builder.append(endTime);
        builder.append(", duration=");
        builder.append(duration);
        builder.append(", startTime=");
        builder.append(startTime);
        builder.append(", published=");
        builder.append(published);
        builder.append(", isResultPublished=");
        builder.append(resultPublished);
        builder.append(", attendedCount=");
        builder.append(attendedCount);
        builder.append(", examineeCount=");
        builder.append(examineeCount);
        builder.append(", passRate=");
        builder.append(passRate);
        builder.append(", passScore=");
        builder.append(passScore);
        builder.append(", average=");
        builder.append(average);
        builder.append("]");
        return builder.toString();
    }
}
