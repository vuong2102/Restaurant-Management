package com.example.ktpm.repository;

import com.example.ktpm.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {
    Client getClientByPhoneNumber(String phoneNumber);
}
