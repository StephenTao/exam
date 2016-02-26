package com.augmentum.exam.dto;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class ShowSizeDTO {

    private int id;
    @NotNull
    @NotEmpty
    private int userId;
    @NotNull
    @NotEmpty
    private int pageSize;
    @NotEmpty
    @NotNull
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
        builder.append("ShowSizeDTO [id=");
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
