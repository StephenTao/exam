package com.augmentum.exam.dto;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class APIDTO {
    private int id;
    @Length(max = 6000)
    private String description;
    @NotNull
    @NotEmpty
    @Length(max = 100)
    private String name;
    private String method;
    private int limit;
    @Length(max = 500)
    private String url;
    @Length(max = 500)
    private String icon;
    @NotNull
    @NotEmpty
    private String status;

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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ApiDTO [id=");
        builder.append(id);
        builder.append(", description=");
        builder.append(description);
        builder.append(", name=");
        builder.append(name);
        builder.append(", method=");
        builder.append(method);
        builder.append(", limit=");
        builder.append(limit);
        builder.append(", url=");
        builder.append(url);
        builder.append(", icon=");
        builder.append(icon);
        builder.append(", state=");
        builder.append(status);
        builder.append("]");
        return builder.toString();
    }
}
