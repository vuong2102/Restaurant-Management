package com.example.ktpm.service.Combo;

import com.example.ktpm.dto.resDto.ComboResDto;

import java.util.List;


public interface IComboService {
    List<ComboResDto> getAllCombos();
    ComboResDto getComboById(Long id);
}
