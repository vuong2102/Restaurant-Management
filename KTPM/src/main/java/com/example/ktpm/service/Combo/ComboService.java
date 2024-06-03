package com.example.ktpm.service.Combo;

import com.example.ktpm.dto.resDto.ComboResDto;
import com.example.ktpm.dto.Mapping.ComboMapper;
import com.example.ktpm.model.Combo;
import com.example.ktpm.repository.IComboRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComboService implements IComboService{
    @Autowired
    private IComboRepository iComboRepo;
    @Autowired
    private ComboMapper comboMapper;
    @Override
    public List<ComboResDto> getAllCombos() {
        List<Combo> comboList = new ArrayList<>();
        List<ComboResDto> comboResDtoList = new ArrayList<>();
        comboList = iComboRepo.findAll();
        for (Combo combo : comboList) {
            ComboResDto comboResDto = comboMapper.comboToComboResDto(combo);
            comboResDtoList.add(comboResDto);
        }
        return comboResDtoList;
    }

    @Override
    public ComboResDto getComboById(Long id) {
        Optional<Combo> opt = iComboRepo.findById(id);
        Combo combo = opt.orElseGet(null);
        ComboResDto comboResDto = comboMapper.comboToComboResDto(combo);
        return comboResDto;
    }

}
