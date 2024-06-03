package com.example.ktpm.dto.Mapping;

import com.example.ktpm.dto.resDto.TableResDto;
import com.example.ktpm.model.TableOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class TableMapper {
    public TableResDto TableToTableDto(TableOrder table){
        TableResDto tableResDto = new TableResDto();
        tableResDto.setId(table.getId());
        tableResDto.setArea(table.getArea());
        tableResDto.setNumber(table.getNumber());
        tableResDto.setStatus(table.getStatus());
        return tableResDto;
    }
}
