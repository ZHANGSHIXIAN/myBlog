package com.zsx.bean;

/**
 * 博客文章分类表
 */
public class Sort {

    private int sortID;//分类id

    private String name;//文章分类名

    private long userId;//所属用户id

    public int getSortID() {
        return sortID;
    }

    public void setSortID(int sortID) {
        this.sortID = sortID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "sortID=" + sortID +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }
}
