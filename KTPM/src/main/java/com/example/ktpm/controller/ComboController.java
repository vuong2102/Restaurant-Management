package com.example.ktpm.controller;

import com.example.ktpm.dto.resDto.ComboResDto;
import com.example.ktpm.service.Combo.IComboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/combos")
public class ComboController {
    @Autowired
    private IComboService ComboService;
    @GetMapping
    public ResponseEntity<List<ComboResDto>> getAllCombos() {
        List<ComboResDto> ComboList = ComboService.getAllCombos();
        return new ResponseEntity<>(ComboList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ComboResDto> getComboById(@PathVariable("id") Long id) {
        ComboResDto combo = ComboService.getComboById(id);
        return new ResponseEntity<>(combo, HttpStatus.OK);
    }
}
