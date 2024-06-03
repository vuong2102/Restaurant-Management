package com.example.ktpm.service.Table;

import com.example.ktpm.dto.resDto.TableResDto;
import com.example.ktpm.model.TableOrder;

import java.util.List;

public interface ITableService {
    List<TableOrder> getAllTables();
    TableOrder getTableById(Long id);
    TableOrder changeStatusTable(TableResDto tableResDto);
    TableOrder changeStatusTableToAvailable(TableResDto tableResDto);
}
