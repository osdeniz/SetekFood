package com.Food2.service;

import com.Food2.model.Food;

import java.util.List;

public interface IFoodService {

    List<Food> getList();

    Food create(Food food);

    Food update(Food food);

    String delete(Integer id);

}
