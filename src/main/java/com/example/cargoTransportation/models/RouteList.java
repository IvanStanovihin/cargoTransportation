package com.example.cargoTransportation.models;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class RouteList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driverId", referencedColumnName = "id")
    private Driver driver;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderItemId", referencedColumnName = "id")
    private OrderItem orderItem;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carID", referencedColumnName = "id")
    private Car car;

    private Integer routeListId;
    private Integer orderRouteListNumber;

    private ZonedDateTime creationDate;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public Integer getRouteListId() {
        return routeListId;
    }

    public void setRouteListId(Integer routeListId) {
        this.routeListId = routeListId;
    }

    public Integer getOrderRouteListNumber() {
        return orderRouteListNumber;
    }

    public void setOrderRouteListNumber(Integer orderRouteListNumber) {
        this.orderRouteListNumber = orderRouteListNumber;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
