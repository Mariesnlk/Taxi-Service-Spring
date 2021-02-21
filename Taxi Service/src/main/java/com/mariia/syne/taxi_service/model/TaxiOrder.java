package com.mariia.syne.taxi_service.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "taxi_order")
public class TaxiOrder {

    @Id
    private Integer id;
    private String addressFrom;
    private String addressTo;
    private int passengersNumber;
    private Integer passengerId;
    private Integer autoId;
    private double price;
    private double discount;
    private int timeToWait;
    private Date date;

    public TaxiOrder() {
    }

    public TaxiOrder(String addressFrom, String addressTo, int passengersNumber, Integer passengerId,
                     Integer autoId, double price, double discount, int timeToWait, Date date) {
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.passengersNumber = passengersNumber;
        this.passengerId = passengerId;
        this.autoId = autoId;
        this.price = price;
        this.discount = discount;
        this.timeToWait = timeToWait;
        this.date = date;
    }

    public TaxiOrder(String addressFrom, String addressTo, int passengersNumber, Integer passengerId, Integer autoId, double price, double discount, int timeToWait) {
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.passengersNumber = passengersNumber;
        this.passengerId = passengerId;
        this.autoId = autoId;
        this.price = price;
        this.discount = discount;
        this.timeToWait = timeToWait;
    }

    public TaxiOrder(Integer id, String addressFrom, String addressTo, int passengersNumber,
                     Integer passengerId, Integer autoId, double price, double discount, int timeToWait, Date date) {
        this.id = id;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.passengersNumber = passengersNumber;
        this.passengerId = passengerId;
        this.autoId = autoId;
        this.price = price;
        this.discount = discount;
        this.timeToWait = timeToWait;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(String addressFrom) {
        this.addressFrom = addressFrom;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }

    public int getPassengersNumber() {
        return passengersNumber;
    }

    public void setPassengersNumber(int passengersNumber) {
        this.passengersNumber = passengersNumber;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public Integer getAutoId() {
        return autoId;
    }

    public void setAutoId(Integer autoId) {
        this.autoId = autoId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getTimeToWait() {
        return timeToWait;
    }

    public void setTimeToWait(int timeToWait) {
        this.timeToWait = timeToWait;
    }

    public Date getDate() {
        return date;
    }

    public void setData(Date data) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", addressFrom='" + addressFrom + '\'' +
                ", addressTo='" + addressTo + '\'' +
                ", passengersNumber=" + passengersNumber +
                ", passengerId=" + passengerId +
                ", autoID=" + autoId +
                ", price=" + price +
                ", discount=" + discount +
                ", timeToWait=" + timeToWait +
                ", data=" + date +
                '}';
    }
}

