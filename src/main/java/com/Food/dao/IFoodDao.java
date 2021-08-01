package com.Food.dao;

import com.Food.model.Food;

import java.util.List;

public interface IFoodDao {

    String message();

    List<Food> foods();

    Food create(Food food);

    Food update(Food food);

    int delete(int id);



}
