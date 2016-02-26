package com.augmentum.exam.model;

import java.util.Date;

public class Examinee {

    private int id;
    private int userId;
    private int examId;
    private int paperId;
    private double score;
    private Date attendedTime;
    private int answeredCount;
    private String comment;
    private String markers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getuserId() {
        return userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }

    public int getexamId() {
        return examId;
    }

    public void setexamId(int examId) {
        this.examId = examId;
    }

    public int getpaperId() {
        return paperId;
    }

    public void setpaperId(int paperId) {
        this.paperId = paperId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getAttendedTime() {
        return attendedTime;
    }

    public void setAttendedTime(Date attendedTime) {
        this.attendedTime = attendedTime;
    }

    public int getAnsweredCount() {
        return answeredCount;
    }

    public void setAnsweredCount(int answeredCount) {
        this.answeredCount = answeredCount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getMarkers() {
        return markers;
    }

    public void setMarkers(String markers) {
        this.markers = markers;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Examinee [id=");
        builder.append(id);
        builder.append(", userId=");
        builder.append(userId);
        builder.append(", examId=");
        builder.append(examId);
        builder.append(", paperId=");
        builder.append(paperId);
        builder.append(", score=");
        builder.append(score);
        builder.append(", attendedTime=");
        builder.append(attendedTime);
        builder.append(", answeredCount=");
        builder.append(answeredCount);
        builder.append(", comment=");
        builder.append(comment);
        builder.append(", markers=");
        builder.append(markers);
        builder.append("]");
        return builder.toString();
    }
}
