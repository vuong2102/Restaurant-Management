package com.example.ktpm.service.Food;


import com.example.ktpm.dto.resDto.FoodOrderResDto;
import com.example.ktpm.dto.resDto.FoodResDto;
import com.example.ktpm.model.Food;

import java.util.List;

public interface IFoodService{
    List<FoodResDto> getAllFoods();
    FoodResDto getFoodById(Long id);
    Boolean deleteFood(Long id) throws Exception;
    Food addFood(FoodResDto foodResDto);
    Food updateFood(Long id, FoodResDto resDto);
    List<FoodOrderResDto> getFoodOrderBillByBillId(Long id);
    List<FoodResDto> getFoodByComboId(Long id);

    List<FoodResDto> findByNameContainingIgnoreCase(String searchTerm);
}
