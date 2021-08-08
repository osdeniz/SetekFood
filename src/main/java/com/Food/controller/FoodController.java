package com.Food.controller;

import com.Food.model.Food;
import com.Food.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/food2", produces = "application/json")
public class FoodController {

    @Autowired
    private IFoodService foodService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
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
    }


}
