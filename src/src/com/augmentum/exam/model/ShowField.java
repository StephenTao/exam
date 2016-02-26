package com.augmentum.exam.model;

import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class ShowField {

    private int id;
    @NotNull
    @NotEmpty
    @MaxLength(45)
    private String name;
    @NotNull
    @NotEmpty
    @MaxLength(45)
    private String category;
    private int order;
    private boolean mustShowed;
    private boolean visible;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isMustShowed() {
        return mustShowed;
    }

    public void setMustShowed(boolean mustShowed) {
        this.mustShowed = mustShowed;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ShowField [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", category=");
        builder.append(category);
        builder.append(", order=");
        builder.append(order);
        builder.append(", mustShowed=");
        builder.append(mustShowed);
        builder.append(", visible=");
        builder.append(visible);
        builder.append("]");
        return builder.toString();
    }
}
