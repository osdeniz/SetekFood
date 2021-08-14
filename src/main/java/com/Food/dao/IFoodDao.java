package com.Food.dao;


import com.Food.entity.FoodEntity;

import java.util.List;

public interface IFoodDao {

    List<FoodEntity> getAllList();

    FoodEntity createOrUpdate(FoodEntity foodEntity);

    FoodEntity getById(Long id);

    int removeById(Long id);



}
