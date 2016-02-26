package com.augmentum.exam.model;

public class ExamineeAnswer {

    private int examineeId;
    private int paperQuestionId;
    private double score;
    private String answer;
    private String comment;
    private String markers;

    public int getExamineeId() {
        return examineeId;
    }

    public void setExamineeId(int examineeId) {
        this.examineeId = examineeId;
    }

    public int getPaperQuestionId() {
        return paperQuestionId;
    }

    public void setPaperQuestionId(int paperQuestionId) {
        this.paperQuestionId = paperQuestionId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
        builder.append("ExamineeAnswer [examineeId=");
        builder.append(examineeId);
        builder.append(", paperQuestionId=");
        builder.append(paperQuestionId);
        builder.append(", score=");
        builder.append(score);
        builder.append(", answer=");
        builder.append(answer);
        builder.append(", comment=");
        builder.append(comment);
        builder.append(", markers=");
        builder.append(markers);
        builder.append("]");
        return builder.toString();
    }
}
