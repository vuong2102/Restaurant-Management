package com.example.ktpm.repository;

import com.example.ktpm.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IFoodRepository extends JpaRepository<Food, Long> {
    List<Food> findByNameContainingIgnoreCase(String searchTerm);
    List<Food> findAllByComboId(Long id);
}
