package com.example.ktpm.service.Bill;

import com.example.ktpm.dto.Mapping.BillMapper;
import com.example.ktpm.dto.Mapping.FoodMapper;
import com.example.ktpm.dto.Mapping.TableMapper;
import com.example.ktpm.dto.resDto.BillResDto;
import com.example.ktpm.dto.resDto.FoodOrderResDto;
import com.example.ktpm.dto.resDto.TableResDto;
import com.example.ktpm.model.Bill;
import com.example.ktpm.model.Food;
import com.example.ktpm.model.FoodOrder;
import com.example.ktpm.model.TableOrder;
import com.example.ktpm.repository.IBillRepository;
import com.example.ktpm.repository.IFoodOrderRepository;
import com.example.ktpm.service.Table.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillService implements IBillService{
    @Autowired
    private IBillRepository iBillRepo;
    @Autowired
    private IFoodOrderRepository iFoodOrderRepo;
    @Autowired
    private BillMapper billMapper;
    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private ITableService iTableService;
    @Autowired
    private TableMapper tableMapper;
    public Object saveNewBill(BillResDto billResDto){
        Bill bill = billMapper.BillResDtoToBill(billResDto);
        return iBillRepo.save(bill);
    }

    @Override
    public Object saveListFoodOrder(List<FoodOrderResDto> orderList) {
        List<FoodOrder> list = new ArrayList<>();
        for (FoodOrderResDto foodO : orderList) {
            FoodOrder foodOrder = foodMapper.foodOrderResDtoToFoodOrder(foodO);
            list.add(foodOrder);
        }
        return iFoodOrderRepo.saveAll(list);
    }
    @Override
    public String changeStatusBill(Long id){
        Optional<Bill> bill = iBillRepo.findById(id);
        Bill bill2 = bill.orElse(null);
        TableOrder table = iTableService.getTableById(bill2.getTableOrderId());
        TableResDto tableRes = tableMapper.TableToTableDto(table);
        TableOrder tableChange = iTableService.changeStatusTableToAvailable(tableRes);
        Bill bill1 = bill.orElse(null);
        if(bill == null) return "Thanh toán không thành công";
        else {
            bill1.setStatusPay("Paid");
            iBillRepo.save(bill1);
            return "Thanh toán thành công";
        }

    }
    @Override
    public List<BillResDto> getAllBill() {
        List<BillResDto> billResDtos = new ArrayList<>();
        List<Bill> billList = iBillRepo.findAll();
        for ( Bill bill : billList) {
            billResDtos.add(billMapper.BillToBillResDto(bill));
        }
        return billResDtos;
    }
}
