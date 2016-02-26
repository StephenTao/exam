package com.augmentum.exam.model;

public class ShowSize {

    private int id;
    private int userId;
    private int pageSize;
    private String category;
    private boolean defaultShowed;

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

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isDefaultShowed() {
        return defaultShowed;
    }

    public void setDefaultShowed(boolean defaultShowed) {
        this.defaultShowed = defaultShowed;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ShowSize [id=");
        builder.append(id);
        builder.append(", userId=");
        builder.append(userId);
        builder.append(", pageSize=");
        builder.append(pageSize);
        builder.append(", category=");
        builder.append(category);
        builder.append(", defaultShowed=");
        builder.append(defaultShowed);
        builder.append("]");
        return builder.toString();
    }

}
