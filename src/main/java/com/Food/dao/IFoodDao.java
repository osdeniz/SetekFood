package com.Food.dao;

import com.Food.model.Food;

import java.util.List;

public interface IFoodDao {
    List<Food> getList();

    /* id null */
    Food create(Food food);

    /* id var */
    Food update(Food food);

    int delete(Integer id);
}
