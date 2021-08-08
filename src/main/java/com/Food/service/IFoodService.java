package com.Food.service;

import com.Food.model.Food;

import java.util.List;

public interface IFoodService {

    List<Food> getList();

    Food create(Food food);

    Food update(Food food);

    String delete(Integer id);

}
