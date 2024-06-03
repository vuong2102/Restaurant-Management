package com.example.ktpm.repository;

import com.example.ktpm.model.Combo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComboRepository extends JpaRepository<Combo, Long> {

}
