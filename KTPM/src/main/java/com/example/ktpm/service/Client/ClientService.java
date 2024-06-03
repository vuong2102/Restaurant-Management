package com.example.ktpm.service.Client;

import com.example.ktpm.dto.Mapping.ClientMapper;
import com.example.ktpm.dto.resDto.ClientResDto;
import com.example.ktpm.model.Client;
import com.example.ktpm.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService implements IClientService{
    @Autowired
    private IClientRepository iClientRepo;
    @Autowired
    private ClientMapper clientMapper;
    @Override
    public Object saveNewClient(ClientResDto clientResDto) {
        Client client = clientMapper.clientResDtoToClient(clientResDto);
        Client client1 = getClientByPhoneNumber(client.getPhoneNumber());
        if(client1 == null) return iClientRepo.save(client);
        else {
            return client1;
        }
    }
    @Override
    public Client getClientByPhoneNumber(String phoneNumber) {
        return iClientRepo.getClientByPhoneNumber(phoneNumber);
    }
    @Override
    public Client updateClientAlreadyExist(String phoneNumber) {
        return iClientRepo.getClientByPhoneNumber(phoneNumber);
    }

    @Override
    public ClientResDto getClientById(Long id) {
        Optional<Client> client = iClientRepo.findById(id);
        Client client1 = client.orElse(null);
        return clientMapper.clientToClientResDto(client1);
    }
}
