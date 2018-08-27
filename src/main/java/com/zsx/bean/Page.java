package com.zsx.bean;

/**
 * 分页类
 */
public class Page {
    //总页数
    private int totlePage;
    //总条数
    private int totleNumber;
    //数据库中limit的参数 从第几条开始取
    private int dbIndex;
    //数据库中limit的参数 每次取多少条
    private int dbNumber;
    //每页显示多少条
    private int pageNumber=5;
    //当前页
    private int currentPage;


    public Page(int totleNumber) {
        this.totleNumber = totleNumber;
    }

    public void count(){
        //计算总页数
        int tempTotlepage=this.totleNumber/this.pageNumber;
        //判断余数 有的话加一页
        int plus=(this.totleNumber%this.pageNumber) ==0? 0:1;
        tempTotlepage+=plus;
        if (tempTotlepage<=0){
            tempTotlepage=1;
        }
        this.totlePage=tempTotlepage;

        //设置当前页数
        //总页数小于当前页数，应将当前页数设置为总页数
        if(this.totlePage<this.currentPage){
            this.currentPage=totlePage;
        }
        //当前页数小于1 设为1
        if(this.currentPage<1) {
            this.currentPage=1;
        }

        //设置limit的参数
        this.dbIndex=(this.currentPage-1)*this.pageNumber;
        this.dbNumber=this.pageNumber;



    }


    public int getTotlePage() {
        return totlePage;
    }

    public void setTotlePage(int totlePage) {
        this.totlePage = totlePage;
    }

    public int getTotleNumber() {
        return totleNumber;
    }

    public void setTotleNumber(int totleNumber) {
        this.totleNumber = totleNumber;
    }

    public int getDbIndex() {
        return dbIndex;
    }

    public void setDbIndex(int dbIndex) {
        this.dbIndex = dbIndex;
    }

    public int getDbNumber() {
        return dbNumber;
    }

    public void setDbNumber(int dbNumber) {
        this.dbNumber = dbNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "Page{" +
                "totlePage=" + totlePage +
                ", totleNumber=" + totleNumber +
                ", dbIndex=" + dbIndex +
                ", dbNumber=" + dbNumber +
                ", pageNumber=" + pageNumber +
                ", currentPage=" + currentPage +
                '}';
    }
}
