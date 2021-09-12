package com.Food.controller;

import com.Food.entity.FoodEntity;
import com.Food.exception.CustomException;
import com.Food.model.Food;
import com.Food.model.dto.FoodDto;
import com.Food.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping(value = "/api/food", produces = "application/json")
public class FoodController {

    @Autowired
    private IFoodService foodService;

    @RequestMapping(value = "createOrUpdate",method = RequestMethod.POST)
    public FoodEntity create(@RequestParam("userId") Long userId, @RequestBody FoodDto foodDto) throws CustomException{
        return foodService.createOrUpdate(foodDto,userId);
    }

    @RequestMapping(value = "alllist",method = RequestMethod.GET)
    public List<FoodEntity> getAllList(){
        return foodService.getAllList();
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public String delete(@RequestParam("userId") Long userId,@PathVariable Long id) throws CustomException {
        return foodService.deleteById(id,userId);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public FoodEntity getById(@PathVariable Long id){
        return  foodService.getById(id);
    }

    @RequestMapping(value = "/search/{search}",method = RequestMethod.GET)
    public List<FoodEntity> search(@PathVariable String search){
        return foodService.search(search);
    }


    @RequestMapping(value = "newCreateOrUpdate",method = RequestMethod.POST)
    public FoodEntity newCreateOrUpdate(@RequestParam("userId") Long userId,@RequestParam("imageFile")MultipartFile file,@RequestParam("payload") String payload) throws CustomException{

        return foodService.newCreateOrUpdate(file,payload,userId);
    }


}
