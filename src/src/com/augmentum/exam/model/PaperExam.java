package com.augmentum.exam.model;


public class PaperExam {

    private int paperId;
    private int examId;

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MapPaperExam [paperId=");
        builder.append(paperId);
        builder.append(", examId=");
        builder.append(examId);
        builder.append("]");
        return builder.toString();
    }
}
