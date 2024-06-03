package com.example.ktpm.service.Food;


import com.example.ktpm.dto.Mapping.FoodMapper;
import com.example.ktpm.dto.resDto.FoodOrderResDto;
import com.example.ktpm.dto.resDto.FoodResDto;
import com.example.ktpm.model.Food;
import com.example.ktpm.model.FoodOrder;
import com.example.ktpm.repository.IFoodOrderRepository;
import com.example.ktpm.repository.IFoodRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodService implements IFoodService{
    @Autowired
    private IFoodRepository iFoodRepo;
    @Autowired
    private IFoodOrderRepository iFoodOrderRepo;
    @Autowired
    private FoodMapper foodMapper;
    @Override
    public List<FoodResDto> getAllFoods(){
        List<Food> foodList = iFoodRepo.findAll();
        List<FoodResDto> foodResDtos = new ArrayList<>();
        for (Food food : foodList) {
            FoodResDto foodResDto = foodMapper.foodToFoodResDto(food);
            foodResDtos.add(foodResDto);
        }
        return foodResDtos;
    }
    @Override
    public FoodResDto getFoodById(Long id){
        Optional<Food> optFood = iFoodRepo.findById(id);
        Food food = optFood.orElse(null);
        FoodResDto foodResDto = foodMapper.foodToFoodResDto(food);
        return foodResDto;
    }
    @Override
    public List<FoodOrderResDto> getFoodOrderBillByBillId(Long billId) {
        List<FoodOrder> foodOrderList = iFoodOrderRepo.findAllByBillId(billId);
        List<FoodOrderResDto> foodOrderResDtos = new ArrayList<>();
        for (FoodOrder foodOrder : foodOrderList) {
            FoodOrderResDto foodOrderResDto = foodMapper.foodOrderToFoodOrderResDto(foodOrder);
            foodOrderResDtos.add(foodOrderResDto);
        }
        return foodOrderResDtos;
    }

    @Override
    public List<FoodResDto> findByNameContainingIgnoreCase(String searchTerm) {
        List<Food> foodList = iFoodRepo.findByNameContainingIgnoreCase(searchTerm);
        List<FoodResDto> foodResDtos = new ArrayList<>();
        for (Food food : foodList) {
            FoodResDto foodResDto1 = foodMapper.foodToFoodResDto(food);
            foodResDtos.add(foodResDto1);
        }
        return foodResDtos;
    }
    @Override
    public List<FoodResDto> getFoodByComboId(Long id) {
        List<Food> foodList = iFoodRepo.findAllByComboId(id);
        List<FoodResDto> foodResDtos = new ArrayList<>();
        for (Food food : foodList) {
            FoodResDto foodResDto1 = foodMapper.foodToFoodResDto(food);
            foodResDtos.add(foodResDto1);
        }
        return foodResDtos;
    }
    @Override
    public Boolean deleteFood(Long id) throws Exception {
        try {
            iFoodRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception("[LỖI]", e);
        }
    }
    @Override
    public Food addFood(@RequestBody FoodResDto foodResDto) {
        try {
            Food food = foodMapper.foodResDtoToFood(foodResDto);
            return iFoodRepo.save(food);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save food", e);
        }
    }
    @Override
    public Food updateFood(Long id, @RequestBody FoodResDto foodResDto) {
        try{
            Food food = iFoodRepo.findById(id).orElse(null);
            if (food != null) {
                food.setName(foodResDto.getName());
                food.setDescription(foodResDto.getDescription());
                food.setPrice(foodResDto.getPrice());
                food.setImage(foodResDto.getImage());
                food.setComboId(foodResDto.getComboId());
                return iFoodRepo.save(food);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
