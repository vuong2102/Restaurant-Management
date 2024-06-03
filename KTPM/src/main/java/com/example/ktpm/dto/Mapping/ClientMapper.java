package com.example.ktpm.dto.Mapping;

import com.example.ktpm.dto.resDto.ClientResDto;
import com.example.ktpm.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ClientMapper {
    public Client clientResDtoToClient(ClientResDto clientResDto){
        Client client = new Client();
        client.setId(clientResDto.getId());
        client.setName(clientResDto.getName());
        client.setPhoneNumber(clientResDto.getPhoneNumber());
        return client;
    }
    public ClientResDto clientToClientResDto(Client client){
        ClientResDto clientResDto = new ClientResDto();
        clientResDto.setId(client.getId());
        clientResDto.setName(client.getName());
        clientResDto.setPhoneNumber(client.getPhoneNumber());
        return clientResDto;
    }
}
