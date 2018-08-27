package com.zsx.bean;

import java.util.Date;

/**
 * 博文表
 */
public class Blog {
    private long blogId;//博客id

    private String title;//博客标题

    private String contentHtml;//博客内容html格式

    private String contentMd;//博客内容md格式

    private Date createTime;//创建时间

    private int sortId;//分类id

    private long userId;//用户id

    private long number;//文章阅读数

    private int type;//是否私有：默认1公共 0私有

    public long getBlogId() {
        return blogId;
    }

    public void setBlogId(long blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public Blog() {
    }

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }

    public String getContentMd() {
        return contentMd;
    }

    public void setContentMd(String contentMd) {
        this.contentMd = contentMd;
    }

    public Blog(String title, String contentHtml, String contentMd, int sortId, int type) {
        this.title = title;
        this.contentHtml = contentHtml;
        this.contentMd = contentMd;
        this.sortId = sortId;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", title='" + title + '\'' +
                ", contentHtml='" + contentHtml + '\'' +
                ", contentMd='" + contentMd + '\'' +
                ", createTime=" + createTime +
                ", sortId=" + sortId +
                ", userId=" + userId +
                ", number=" + number +
                ", type=" + type +
                '}';
    }
}
