package com.example.cargoTransportation.models;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "order_item")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer idCustomer;
    private Integer idPlace;
    private Integer cargoWeight;
    private String creationDate;
    private Boolean status;
    private String note;

    public Order(){

    }

    public Order(Integer idCustomer, Integer idPlace, Integer cargoWeight, String note, String creationDate) {
        this.idCustomer = idCustomer;
        this.idPlace = idPlace;
        this.cargoWeight = cargoWeight;
        this.note = note;
        this.creationDate = creationDate;
        this.status = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(Integer idPlace) {
        this.idPlace = idPlace;
    }

    public Integer getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(Integer cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
