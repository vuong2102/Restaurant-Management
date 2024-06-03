package com.example.ktpm.dto.resDto;

import com.example.ktpm.model.Client;
import com.example.ktpm.model.FoodOrder;
import com.example.ktpm.model.TableOrder;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
public class BillResDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("clientId")
    private Long clientId;
    @JsonProperty("tableOrderId")
    private Long tableOrderId;
    @JsonProperty("totalPrice")
    private Long totalPrice;
    @JsonProperty("dateOrder")
    private Date dateOrder;
    @JsonProperty("statusPay")
    private String statusPay;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getTotalPrice() {
        return totalPrice;
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

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getStatusPay() {
        return statusPay;
    }

    public void setStatusPay(String statusPay) {
        this.statusPay = statusPay;
    }
}
