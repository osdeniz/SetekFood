package com.Food2.serviceimpl;

import com.Food2.dao.IFoodDao;
import com.Food2.model.Food;
import com.Food2.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class FoodServiceImpl implements IFoodService {

    @Autowired
    private IFoodDao foodDao;

    @Override
    public List<Food> getList() {
        return foodDao.getList();
    }

    @Override
    public Food create(Food food) {
        Date newDate = new Date();
        String pattern = "dd-MMM-yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(newDate);
        food.setCreateDate(date);
        return foodDao.create(food);
    }

    @Override
    public Food update(Food food) {
        Date newDate = new Date();
        String pattern = "dd-MMM-yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(newDate);
        food.setLastModifiadDate(date);
        return foodDao.update(food);
    }

    @Override
    public String delete(Integer id) {
        int status = foodDao.delete(id);

        if (status == 1){
            return "İşlem Başarılı";
        }

        return  "İşlem Başarısız";
    }
}
