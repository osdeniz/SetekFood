package com.Food.serviceimpl;

import com.Food.dao.IAuthDao;
import com.Food.dao.IFoodDao;
import com.Food.entity.FoodEntity;
import com.Food.entity.UserEntity;
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

    @Autowired
    private IAuthDao authDao;


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


        if(foodDto.getUserId() != null){
            UserEntity currentUser = authDao.getByUserId(foodDto.getUserId());
            foodEntity.setUser(currentUser);
        }
        return foodDao.createOrUpdate(foodEntity);
    }

    @Override
    public String deleteById(Long id) {
        int result = foodDao.removeById(id);
        return result == 1 ? "İşlem başarılı." : "İşlem başarısız.";
    }

    @Override
    public FoodEntity getById(Long id) {
        return foodDao.getById(id);
    }

    @Override
    public List<FoodEntity> search(String search) {
        return foodDao.search(search);
    }
}
