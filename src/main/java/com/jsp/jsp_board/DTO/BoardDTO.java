package com.jsp.jsp_board.DTO;

import java.sql.Date;

public class BoardDTO {
    private int boardId;
    private String title;
    private String content;
    private String category;
    private String subCategory;
    private String name;
    private String nickName;
    private String email;
    private int userId;
    private int hits;
    private int recommend;
    private Date createDate;

    public int getBoardId() { return boardId; }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) { this.title = title; }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getNickName() { return nickName; }

    public void setNickName(String nickName) { this.nickName = nickName; }

    public String getEmail() { return email; }

    public void setEmail(String email) {this.email = email; }

    public int getUserId() { return userId; }

    public void setUserId(int userId) { this.userId = userId; }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
