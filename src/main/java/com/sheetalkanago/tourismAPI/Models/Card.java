package com.sheetalkanago.tourismAPI.Models;

import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardID;
    private String cardName;
    private double lat;
    private double lng;
    private String description;
    private String category;
    private double expense;
    private double timeRequired;
    private Date timeToVisitStart;
    private Date TimeToVisitEnd;
    private double pointsRequired;

    public Card() {}

    public Card(String cardName, String description) {
        this.cardName = cardName;
        this.description = description;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public double getTimeRequired() {
        return timeRequired;
    }

    public void setTimeRequired(double timeRequired) {
        this.timeRequired = timeRequired;
    }

    public Date getTimeToVisitStart() {
        return timeToVisitStart;
    }

    public void setTimeToVisitStart(Date timeToVisitStart) {
        this.timeToVisitStart = timeToVisitStart;
    }

    public Date getTimeToVisitEnd() {
        return TimeToVisitEnd;
    }

    public void setTimeToVisitEnd(Date timeToVisitEnd) {
        TimeToVisitEnd = timeToVisitEnd;
    }

    public double getPointsRequired() {
        return pointsRequired;
    }

    public void setPointsRequired(double pointsRequired) {
        this.pointsRequired = pointsRequired;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardID=" + cardID +
                ", cardName='" + cardName + '\'' +
                '}';
    }
}
