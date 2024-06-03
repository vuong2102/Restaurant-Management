package com.example.ktpm.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "clientId")
    private Long clientId;
    @Column(name = "tableOrderId")

    private Long tableOrderId;
    @Column(name = "totalPrice")
    private Long totalPrice;
    @Column(name = "dateOrder")
    private Date dateOrder;
    @Column(name = "statusPay")
    private String statusPay;

    public String getStatusPay() {
        return statusPay;
    }

    public void setStatusPay(String statusPay) {
        this.statusPay = statusPay;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getTableOrderId() {
        return tableOrderId;
    }

    public void setTableOrderId(Long tableId) {
        this.tableOrderId = tableId;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }
}
