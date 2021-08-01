package com.Food.daoimp;

import com.Food.dao.IFoodDao;
import com.Food.model.Food;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FoodDaoImpl implements IFoodDao {

    private static List<Food> foods = new ArrayList<>();

    @Override
    public String message() {
        return "hello";
    }

    @Override
    public List<Food> foods() {
        return foods;
    }

    @Override
    public Food create(Food food) {
        foods.add(food);
        return food;
    }

    @Override
    public Food update(Food food) {
        for (Food item : foods){
            if(food.getId() == item.getId()){
                item.setTitle(food.getTitle());
                item.setDescription(food.getDescription());
                item.setList(food.getList());
            }
        }
        return food;
    }

    @Override
    public int delete(int id) {
        int index = -1;
        if (foods.size() > 0){
            for (int i=0;i<foods.size();i++){
                if(foods.get(i).getId() == id){
                    index = i;
                    break;
                }
            }

            foods.remove(index);
        }
        return index;
    }



}
