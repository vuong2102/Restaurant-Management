package com.example.ktpm.service.Bill;

import com.example.ktpm.dto.resDto.BillResDto;
import com.example.ktpm.dto.resDto.FoodOrderResDto;
import com.example.ktpm.model.FoodOrder;

import java.util.List;

public interface IBillService {
    Object saveNewBill(BillResDto billResDto);
    Object saveListFoodOrder(List<FoodOrderResDto> orderList);
    List<BillResDto> getAllBill();
    String changeStatusBill(Long id);
}
