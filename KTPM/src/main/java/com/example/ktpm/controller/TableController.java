package com.example.ktpm.controller;

import com.example.ktpm.dto.Mapping.TableMapper;
import com.example.ktpm.dto.resDto.TableResDto;
import com.example.ktpm.model.Food;
import com.example.ktpm.model.TableOrder;
import com.example.ktpm.service.Table.ITableService;
import com.example.ktpm.service.Table.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class TableController {
    @Autowired
    private ITableService iTableService;
    @Autowired
    private TableMapper tableMapper;
    @GetMapping("/tables")
    public ResponseEntity<List<TableResDto>> getAllTable(){
        List<TableOrder> orderList = iTableService.getAllTables();
        List<TableResDto> list = new ArrayList<>();
        for (TableOrder table : orderList) {
            list.add(tableMapper.TableToTableDto(table));
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/tables/{id}")
    public ResponseEntity<TableResDto> getTableById(@PathVariable("id") Long id){
        TableOrder table = iTableService.getTableById(id);
        TableResDto tableResDto = tableMapper.TableToTableDto(table);
        return new ResponseEntity<>(tableResDto, HttpStatus.OK);
    }
    @PostMapping("/change-status")
    public ResponseEntity<TableResDto> changeStatusTable(@RequestBody TableResDto tableResDto){
        TableOrder table = iTableService.changeStatusTable(tableResDto);
        TableResDto tableRes = tableMapper.TableToTableDto(table);
        return new ResponseEntity<>(tableRes, HttpStatus.OK);
    }
    @GetMapping("/change-status-byId/{id}")
    public String changeStatusTableById(@PathVariable("id") Long id){
        TableOrder table = iTableService.getTableById(id);
        TableResDto tableRes = tableMapper.TableToTableDto(table);
        TableOrder tableChange = iTableService.changeStatusTable(tableRes);
        return "Sua thanh cong";
    }
}
