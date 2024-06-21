package com.jsp.jsp_board.DTO;

public class UserDTO {
    protected int userId;
    protected String password;
    protected String email;
    protected float position;
    protected int userRole;
    protected String id;
    protected String nickName;
    protected String name;
    protected String expireDate;
    protected String maketingFlag;
    protected int marketingFlag;
    protected int profile;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getPosition() {
        return position;
    }

    public void setPosition(float position) {
        this.position = position;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getMaketingDate() {
        return maketingFlag;
    }

    public void setMaketingDate(String maketingFlag) {
        this.maketingFlag = maketingFlag;
    }

    public int getMarketingFlag() {
        return marketingFlag;
    }

    public void setMarketingFlag(int marketingFlag) {
        this.marketingFlag = marketingFlag;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }
}
