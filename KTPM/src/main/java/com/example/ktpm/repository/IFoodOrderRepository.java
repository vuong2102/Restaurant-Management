package com.example.ktpm.repository;

import com.example.ktpm.model.Bill;
import com.example.ktpm.model.Combo;
import com.example.ktpm.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFoodOrderRepository extends JpaRepository<FoodOrder, Long> {
    List<FoodOrder> findAllByBillId(Long billId);

}
