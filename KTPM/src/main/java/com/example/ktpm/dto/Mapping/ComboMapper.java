package com.example.ktpm.dto.Mapping;

import com.example.ktpm.dto.resDto.ComboResDto;
import com.example.ktpm.model.Combo;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public abstract class ComboMapper {
    public ComboResDto comboToComboResDto(Combo combo){
        ComboResDto comboResDto = new ComboResDto();
        comboResDto.setId(combo.getId());
        comboResDto.setName(combo.getName());
        comboResDto.setDescription(combo.getDescription());
        comboResDto.setImage(combo.getImage());
        comboResDto.setPrice(combo.getPrice());
        comboResDto.setQuantity(combo.getQuantity());
        comboResDto.setAvailable(combo.getAvailable());
        return comboResDto;
    }
}
