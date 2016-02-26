package com.augmentum.common.dto;

import java.util.Date;

import net.sf.oval.constraint.NotNull;

public class CMSPageDTO {

    private Integer id;
    @NotNull
    private String title;
    @NotNull
    private String url;
    @NotNull
    private String content;
    private String template;
    private String metaKeywords;
    private String metaDescription;
    @NotNull
    private Integer creator;
    private String creatorName;
    private Date createdTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CMSPage [id=");
        builder.append(id);
        builder.append(", title=");
        builder.append(title);
        builder.append(", url=");
        builder.append(url);
        builder.append(", content=");
        builder.append(content);
        builder.append(", template=");
        builder.append(template);
        builder.append(", metaKeywords=");
        builder.append(metaKeywords);
        builder.append(", metaDescription=");
        builder.append(metaDescription);
        builder.append(", creator=");
        builder.append(creator);
        builder.append(", creatorName=");
        builder.append(creatorName);
        builder.append(", createdTime=");
        builder.append(createdTime);
        builder.append("]");
        return builder.toString();
    }
}
