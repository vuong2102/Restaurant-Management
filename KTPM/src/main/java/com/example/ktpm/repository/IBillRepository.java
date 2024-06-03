package com.example.ktpm.repository;

import com.example.ktpm.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findAll();
}
