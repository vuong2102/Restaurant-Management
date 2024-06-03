package com.example.ktpm.dto.Mapping;

import com.example.ktpm.dto.resDto.BillResDto;
import com.example.ktpm.model.Bill;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class BillMapper {
    @Autowired
    private ClientMapper clientMapper;
    public Bill BillResDtoToBill(BillResDto billResDto){
        Bill bill = new Bill();
        bill.setClientId(0L);
        bill.setTableOrderId(billResDto.getTableOrderId());
        bill.setTotalPrice(billResDto.getTotalPrice());
        bill.setDateOrder(billResDto.getDateOrder());
        bill.setStatusPay("Unpaid");
        return bill;
    }
    public BillResDto BillToBillResDto(Bill bill){
        BillResDto bill1 = new BillResDto();
        bill1.setId(bill.getId());
        bill1.setClientId(0L);
        bill1.setTableOrderId(bill.getTableOrderId());
        bill1.setTotalPrice(bill.getTotalPrice());
        bill1.setDateOrder(bill.getDateOrder());
        bill1.setStatusPay(bill.getStatusPay());
        return bill1;
    }
}
