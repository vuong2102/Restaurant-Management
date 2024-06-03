package com.example.ktpm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class ListFoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="billId")
    private Long billId;
    @Column(name = "foodId")
    private Long foodId;
}
