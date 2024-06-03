package com.example.ktpm.service.Table;

import com.example.ktpm.dto.resDto.TableResDto;
import com.example.ktpm.model.Food;
import com.example.ktpm.model.TableOrder;
import com.example.ktpm.repository.ITableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TableService implements ITableService{
    @Autowired
    private ITableRepository iTableRepository;
    @Override
    public List<TableOrder> getAllTables(){
        List<TableOrder> list = iTableRepository.findAll();
        return list;
    }
    @Override
    public TableOrder getTableById(Long id){
        Optional<TableOrder> tableOpt = iTableRepository.findById(id);
        TableOrder table = tableOpt.orElse(null);
        return table;
    }

    @Override
    public TableOrder changeStatusTable(@RequestBody TableResDto tableResDto) {
        try{
            TableOrder tableOrder = iTableRepository.findById(tableResDto.getId()).orElse(null);
            String status = "Unavailable";
            if (tableOrder != null) {
                tableOrder.setId(tableResDto.getId());
                tableOrder.setArea(tableResDto.getArea());
                if(Objects.equals(tableResDto.getStatus(), "Available")){
                    tableOrder.setStatus(status);
                }
                else tableOrder.setStatus(tableResDto.getStatus());
                tableOrder.setNumber(tableResDto.getNumber());
                return iTableRepository.save(tableOrder);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public TableOrder changeStatusTableToAvailable(@RequestBody TableResDto tableResDto) {
        try{
            TableOrder tableOrder = iTableRepository.findById(tableResDto.getId()).orElse(null);
            String status = "Available";
            if (tableOrder != null) {
                tableOrder.setId(tableResDto.getId());
                tableOrder.setArea(tableResDto.getArea());
                if(Objects.equals(tableResDto.getStatus(), "Unavailable")){
                    tableOrder.setStatus(status);
                }
                else tableOrder.setStatus(tableResDto.getStatus());
                tableOrder.setNumber(tableResDto.getNumber());
                return iTableRepository.save(tableOrder);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
