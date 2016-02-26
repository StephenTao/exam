package com.augmentum.common.dto;

import java.util.Date;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class CMSBlockDTO {

    private Integer id;
    @NotNull
    private String content;
    @NotNull
    @NotEmpty
    private String alias;
    private Date createdTime;
    private Date updatedTime;
    @NotNull
    private Integer creator;
    private String creatorName;
    @NotNull
    private Integer isActived;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Integer getIsActived() {
        return isActived;
    }

    public void setIsActived(Integer isActived) {
        this.isActived = isActived;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CMSBlockDTO [id=");
        builder.append(id);
        builder.append(", alias=");
        builder.append(alias);
        builder.append(", content=");
        builder.append(content);
        builder.append(", createdTime=");
        builder.append(createdTime);
        builder.append(", updatedTime=");
        builder.append(updatedTime);
        builder.append(", creator=");
        builder.append(creator);
        builder.append(", creatorName=");
        builder.append(creatorName);
        builder.append(", isActived=");
        builder.append(isActived);
        builder.append("]");
        return builder.toString();
    }
}
