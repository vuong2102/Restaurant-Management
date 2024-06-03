package com.example.ktpm.controller;

import com.example.ktpm.dto.resDto.BillResDto;
import com.example.ktpm.dto.resDto.ClientResDto;
import com.example.ktpm.dto.resDto.FoodOrderResDto;
import com.example.ktpm.model.FoodOrder;
import com.example.ktpm.service.Bill.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BillController {
    @Autowired
    private IBillService iBillService;
    @GetMapping("/get-bill")
    public ResponseEntity<Object> getAllBill(){
        List<BillResDto> billResDtos = iBillService.getAllBill();
        return new ResponseEntity<>(billResDtos, HttpStatus.OK);
    }
    @GetMapping("/change-status-bill/{id}")
    public ResponseEntity<String> changeStatusBill(@PathVariable("id") Long id){
        String status = iBillService.changeStatusBill(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
    @PostMapping("/add-bill")
    public ResponseEntity<Object> saveNewBill(@RequestBody BillResDto billResDto) {
        try{
            Object newClient = iBillService.saveNewBill(billResDto);
            return ResponseEntity.ok(newClient);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to add bill");
        }
    }
    @PostMapping("/add-list-foodOrder")
    public ResponseEntity<Object> saveListFoodOrder(@RequestBody List<FoodOrderResDto> orderList) {
        try{
            Object newClient = iBillService.saveListFoodOrder(orderList);
            return ResponseEntity.ok(newClient);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to add list order food");
        }
    }

}
