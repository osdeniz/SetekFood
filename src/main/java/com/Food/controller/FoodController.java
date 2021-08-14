package com.Food.controller;

import com.Food.entity.FoodEntity;
import com.Food.model.Food;
import com.Food.model.dto.FoodDto;
import com.Food.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/food", produces = "application/json")
public class FoodController {

    @Autowired
    private IFoodService foodService;

    @RequestMapping(value = "createOrUpdate",method = RequestMethod.POST)
    public FoodEntity create(@RequestBody FoodDto foodDto){
        return foodService.createOrUpdate(foodDto);
    }

    @RequestMapping(value = "alllist",method = RequestMethod.GET)
    public List<FoodEntity> getAllList(){
        return foodService.getAllList();
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id){
        return foodService.deleteById(id);
    }


}
