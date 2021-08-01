package com.Food.service;

import com.Food.model.Food;

import java.util.List;

public interface IFoodService {

    String message();

    List<Food> foods();

    Food create(Food food);

    Food update(Food food);

    String delete(int id);
}
