package com.Food.controller;

import com.Food.entity.FoodEntity;
import com.Food.model.Food;
import com.Food.model.dto.FoodDto;
import com.Food.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/api/food", produces = "application/json")
public class FoodController {

    @Autowired
    private IFoodService foodService;


    @RequestMapping(value = "createOrUpdate",method = RequestMethod.POST)
    public FoodEntity create(@RequestBody FoodDto foodDto){
        return foodService.createOrUpdate(foodDto);
    }


   /* @RequestMapping(value = "list",method = RequestMethod.GET)
    public List<Food> getList(){
        return foodService.getList();
    }

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public Food create(@RequestBody Food food){
        return foodService.create(food);
    }

    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public Food update(@RequestBody Food food){
        return foodService.update(food);
    }

    @RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id){
        return foodService.delete(id);
    } */


}
