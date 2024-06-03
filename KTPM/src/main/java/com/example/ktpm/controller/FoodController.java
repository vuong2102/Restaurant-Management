package com.example.ktpm.controller;

import com.example.ktpm.dto.Mapping.FoodMapper;
import com.example.ktpm.dto.resDto.FoodOrderResDto;
import com.example.ktpm.dto.resDto.FoodResDto;
import com.example.ktpm.model.Food;
import com.example.ktpm.service.Food.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/foods")
public class FoodController {
    @Autowired
    private IFoodService foodService;
    @Autowired
    private FoodMapper foodMapper;
    @GetMapping("")
    public ResponseEntity<List<FoodResDto>> getFoods() {
        List<FoodResDto> foodList = foodService.getAllFoods();
        return new ResponseEntity<>(foodList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FoodResDto> getFoodById(@PathVariable("id") Long id) {
        try{
            FoodResDto food = foodService.getFoodById(id);
            return new ResponseEntity<>(food, HttpStatus.OK);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to get foodOrder by billId");
        }
    }
    @GetMapping("/billId/{id}")
    public ResponseEntity<List<FoodOrderResDto>> getFoodOrderBillByBillId(@PathVariable("id") Long id) {
        try{
            List<FoodOrderResDto> foodOrderResDtos = foodService.getFoodOrderBillByBillId(id);
            return new ResponseEntity<>(foodOrderResDtos, HttpStatus.OK);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to get food by id");
        }
    }
    @PostMapping("/add-food")
    public ResponseEntity<Food> addFood(@RequestBody FoodResDto food) {
        try{
            Food savedFood = foodService.addFood(food);
            return ResponseEntity.ok(savedFood);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to add food");
        }
    }
    @DeleteMapping("/delete/{id}")
    public Boolean deleteFood(@PathVariable("id") Long id) {
        try {
            foodService.deleteFood(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<FoodResDto> updateFood(@PathVariable(value = "id") Long id, @RequestBody FoodResDto resDto) {
        Food food = foodService.updateFood(id, resDto);
        if (food != null) {
            return ResponseEntity.ok(foodMapper.foodToFoodResDto(food));
        }
        return ResponseEntity.notFound().build();
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Food> updateFood(@PathVariable(value = "id") Long id, @RequestBody Food foodDetails) {
//        Food updatedFood = foodService.updateFood(id, foodDetails);
//        return ResponseEntity.ok(updatedFood);
//    }
    @GetMapping("/searchTerm")
    public List<FoodResDto> searchFood(@RequestParam String searchTerm) {
        return foodService.findByNameContainingIgnoreCase(searchTerm);
    }
    @GetMapping("/combo/{comboId}")
    public List<FoodResDto> getListFoodByComboId(@PathVariable("comboId") Long comboId) {
        return foodService.getFoodByComboId(comboId);
    }

}
