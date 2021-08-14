package com.Food.serviceimpl;

import com.Food.dao.IFoodDao;
import com.Food.entity.FoodEntity;
import com.Food.model.Food;
import com.Food.model.dto.FoodDto;
import com.Food.service.IFoodService;
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
    public List<FoodEntity> getAllList() {
        return foodDao.getAllList();
    }

    @Override
    public FoodEntity createOrUpdate(FoodDto foodDto) {
        FoodEntity foodEntity = null;
        if(foodDto.getId() != null){
            foodEntity = foodDao.getById(foodDto.getId());
        }else{
            foodEntity = new FoodEntity();
            foodEntity.setCreateDate(new Date());
        }
        foodEntity.setTitle(foodDto.getTitle());
        foodEntity.setDescription(foodDto.getDescription());
        foodEntity.setFoodDeails(foodDto.getFoodDetails());

        return foodDao.createOrUpdate(foodEntity);
    }

    @Override
    public String deleteById(Long id) {
        int result = foodDao.removeById(id);
        return result == 1 ? "İşlem başarılı." : "İşlem başarısız.";
    }
}
