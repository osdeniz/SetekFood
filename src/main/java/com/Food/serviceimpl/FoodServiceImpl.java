package com.Food.serviceimpl;

import com.Food.dao.IFoodDao;
import com.Food.model.Food;
import com.Food.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FoodServiceImpl implements IFoodService {

    private static int i = 0;

    @Autowired
    private IFoodDao foodDao;

    @Override
    public String message() {
        return foodDao.message();
    }

    @Override
    public List<Food> foods() {
        return foodDao.foods();
    }

    @Override
    public Food create(Food food) {
        i = i + 1;
        food.setId(i);
        return foodDao.create(food);
    }

    @Override
    public Food update(Food food) {
        return foodDao.update(food);

    }

    @Override
    public String delete(int id) {
        int status = foodDao.delete(id);
        if(status != -1){
            return "İşlem başarılı";
        }
        return "İşlem başarısız";
    }

}
