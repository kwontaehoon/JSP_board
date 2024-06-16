package com.jsp.jsp_board.DTO;

import java.time.LocalDateTime;

public class BoardDTO {
    private Number reservationId;
    private String subTitle;
    private Number peopleCount;
    private String LocationDetails;
    private Number score;
    private LocalDateTime createDate;
    private String deadLine;
    private Float xCoordinate;
    private Float yCoordinate;
    private String category1;
    private String category2;
    private String category3;

    public Number getReservationId() {
        return reservationId;
    }

    public void setReservationId(Number reservationId) {
        this.reservationId = reservationId;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Number getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Number peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getLocationDetails() {
        return LocationDetails;
    }

    public void setLocationDetails(String locationDetails) {
        LocationDetails = locationDetails;
    }

    public Number getScore() {
        return score;
    }

    public void setScore(Number score) {
        this.score = score;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public Float getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(Float xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Float getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(Float yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public String getCategory3() {
        return category3;
    }

    public void setCategory3(String category3) {
        this.category3 = category3;
    }
}


