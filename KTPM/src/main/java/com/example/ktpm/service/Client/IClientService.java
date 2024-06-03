package com.example.ktpm.service.Client;

import com.example.ktpm.dto.resDto.ClientResDto;
import com.example.ktpm.model.Client;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public interface IClientService {
    Object saveNewClient(@RequestBody ClientResDto clientResDto);
    Client getClientByPhoneNumber(String phoneNumber);
    Client updateClientAlreadyExist(String phoneNumber);
    ClientResDto getClientById(Long id);
}
