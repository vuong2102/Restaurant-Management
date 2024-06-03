package com.example.ktpm.controller;

import com.example.ktpm.dto.Mapping.ClientMapper;
import com.example.ktpm.dto.resDto.ClientResDto;
import com.example.ktpm.dto.resDto.FoodResDto;
import com.example.ktpm.model.Client;
import com.example.ktpm.model.Food;
import com.example.ktpm.service.Client.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class ClientController {
    @Autowired
    private IClientService iClientService;
    @Autowired
    private ClientMapper clientMapper;
    @GetMapping("/clients/{id}")
    public ResponseEntity<Object> getClientById(@PathVariable("id") Long id){
        ClientResDto client = iClientService.getClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    @PostMapping("/add-client")
    public ResponseEntity<Object> saveNewclient(@RequestBody ClientResDto clientResDto) {
        try{
            Object newClient = iClientService.saveNewClient(clientResDto);
            return ResponseEntity.ok(newClient);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to add client");
        }
    }
}
