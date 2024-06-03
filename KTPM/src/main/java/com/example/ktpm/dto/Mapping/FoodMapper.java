package com.example.ktpm.dto.Mapping;

import com.example.ktpm.dto.resDto.FoodOrderResDto;
import com.example.ktpm.dto.resDto.FoodResDto;
import com.example.ktpm.model.Food;
import com.example.ktpm.model.FoodOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class FoodMapper {
    public FoodResDto foodToFoodResDto(Food food){
        FoodResDto foodResDto = new FoodResDto();
        foodResDto.setId(food.getId());
        foodResDto.setName(food.getName());
        foodResDto.setDescription(food.getDescription());
        foodResDto.setImage(food.getImage());
        foodResDto.setPrice(food.getPrice());
        foodResDto.setComboId(food.getComboId());
        return foodResDto;
    }
    public Food foodResDtoToFood(FoodResDto foodResDto){
        Food food = new Food();
        food.setId(foodResDto.getId());
        food.setName(foodResDto.getName());
        food.setDescription(foodResDto.getDescription());
        food.setImage(foodResDto.getImage());
        food.setPrice(foodResDto.getPrice());
        return food;
    }
    public FoodOrderResDto foodOrderToFoodOrderResDto(FoodOrder foodOrder){
        FoodOrderResDto foodOrderResDto = new FoodOrderResDto();
        foodOrderResDto.setId(foodOrder.getId());
        foodOrderResDto.setName(foodOrder.getName());
        foodOrderResDto.setFoodId(foodOrder.getFoodId());
        foodOrderResDto.setPrice(foodOrder.getPrice());
        foodOrderResDto.setQuantity(foodOrder.getQuantity());
        foodOrderResDto.setBillId(foodOrder.getBillId());
        return foodOrderResDto;
    }
    public FoodOrder foodOrderResDtoToFoodOrder(FoodOrderResDto foodOrderResDto){
        FoodOrder foodOrder = new FoodOrder();
        foodOrder.setId(foodOrderResDto.getId());
        foodOrder.setName(foodOrderResDto.getName());
        foodOrder.setQuantity(foodOrderResDto.getQuantity());
        foodOrder.setFoodId(foodOrderResDto.getFoodId());
        foodOrder.setPrice(foodOrderResDto.getPrice());
        foodOrder.setBillId(foodOrderResDto.getBillId());
        return foodOrder;
    }
}
