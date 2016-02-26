package com.augmentum.exam.dto;

import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class PaperPartDTO {

    private int id;
    @NotNull
    @NotEmpty
    @MaxLength(100)
    private String name;
    private int totalQuestion;
    private double totalScore;
    @MaxLength(6000)
    private String description;
    private int order;
    private int paperId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(int totalQuestion) {
        this.totalQuestion = totalQuestion;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PaperPart [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", totalQuestion=");
        builder.append(totalQuestion);
        builder.append(", totalScore=");
        builder.append(totalScore);
        builder.append(", description=");
        builder.append(description);
        builder.append(", order=");
        builder.append(order);
        builder.append(", paperId=");
        builder.append(paperId);
        builder.append("]");
        return builder.toString();
    }
}
