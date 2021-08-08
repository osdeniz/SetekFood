package com.Food.daoimpl;

import com.Food.dao.IFoodDao;
import com.Food.model.Food;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FoodDaoImpl implements IFoodDao {

    private static List<Food> foods = new ArrayList<>();
    private static int i = 0;

    /* test */


    @Override
    public List<Food> getList() {
        return foods;
    }

    @Override
    public Food create(Food food) {
        i = i + 1;
        food.setId(i);
        foods.add(food);
        return food;
    }

    @Override
    public Food update(Food food) {
        for (Food item:foods){
            if(item.getId() == food.getId()){
                item.setTitle(food.getTitle());
                item.setDescription(food.getDescription());
                item.setList(food.getList());
                item.setLastModifiadDate(food.getLastModifiadDate());
            }
        }
        return food;
    }

    @Override
    public int delete(Integer id) {
        int index = -1;

        for (int i=0 ;i<foods.size();i++){
            if(foods.get(i).getId() == id){
                index = i;
                break;
            }
        }

        if (index != -1){
            foods.remove(index);
            return 1;
        }

        return 0;
    }
}
