package com.Food.service;

import com.Food.entity.FoodEntity;
import com.Food.model.Food;
import com.Food.model.dto.FoodDto;

import java.util.List;

public interface IFoodService {

    List<FoodEntity> getAllList();

    FoodEntity createOrUpdate(FoodDto foodDto,Long userId) throws Exception;

    String deleteById(Long id,Long userId) throws Exception;

    FoodEntity getById(Long id);

    List<FoodEntity> search(String search);


}
