package com.daniel.grboard.vo;

/**
 * Created by daniel on 15. 4. 4.
 */
public class Article {
    private int articleNo;
    private String title;
    private String contents;
    private String writer;
    private int recommendCount;
    private int viewCount;
    private String registeredTime;

    public Article(String title, String contents, String writer) {
        this.title = title;
        this.contents = contents;
        this.writer = writer;
    }

    public Article(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public Article(int articleNo, String title, String contents, String writer, int recommendCount, int viewCount, String registeredTime) {
        this.articleNo = articleNo;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
        this.recommendCount = recommendCount;
        this.viewCount = viewCount;
        this.registeredTime = registeredTime;
    }

    public Article() {

    }

    public Article(int articleNo, String title, String contents) {
        this.articleNo = articleNo;
        this.title = title;
        this.contents = contents;
    }

    public int getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(int articleNo) {
        this.articleNo = articleNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getRecommendCount() {
        return recommendCount;
    }

    public void setRecommendCount(int recommendCount) {
        this.recommendCount = recommendCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(String registeredTime) {
        this.registeredTime = registeredTime;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleNo=" + articleNo +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", writer='" + writer + '\'' +
                ", recommendCount=" + recommendCount +
                ", viewCount=" + viewCount +
                ", registeredTime='" + registeredTime + '\'' +
                '}';
    }
}
