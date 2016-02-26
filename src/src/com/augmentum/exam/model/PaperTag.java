package com.augmentum.exam.model;

public class PaperTag {

    private int paperId;
    private int tagId;

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PaperTag [paperId=");
        builder.append(paperId);
        builder.append(", tagId=");
        builder.append(tagId);
        builder.append("]");
        return builder.toString();
    }
}
