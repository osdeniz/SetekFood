package com.Food.serviceimpl;

import com.Food.dao.IAuthDao;
import com.Food.dao.IFoodDao;
import com.Food.entity.FoodEntity;
import com.Food.entity.ImageEntity;
import com.Food.entity.UserEntity;
import com.Food.exception.CustomException;
import com.Food.model.Food;
import com.Food.model.dto.FoodDto;
import com.Food.service.IFoodService;
import com.Food.utility.ImageUtility;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
        List<FoodEntity> foods = foodDao.getAllList();
        for (FoodEntity food:foods){
            if(food.getImage() != null){
                food.getImage().setImageByte(ImageUtility.decompressBytes(food.getImage().getImageByte()));
            }
        }

        return foods;
    }

    @Override
    public FoodEntity createOrUpdate(FoodDto foodDto ,Long userId) throws CustomException{
        FoodEntity foodEntity = null;
        if(foodDto.getId() != null){
            foodEntity = foodDao.getById(foodDto.getId());
        }else{
            foodEntity = new FoodEntity();
            foodEntity.setCreateDate(new Date());
        }
        foodEntity.setTitle(foodDto.getTitle());
        foodEntity.setDescription(foodDto.getDescription());
        foodEntity.setFoodDetails(foodDto.getFoodDetails());




        if(userId != null){

            UserEntity currentUser = authDao.getByUserId(userId);
            foodEntity.setUser(currentUser);
        }

        if (foodEntity.getId() != null){

            if(foodEntity.getUser() != null && foodEntity.getUser().getId() == userId){
                return foodDao.createOrUpdate(foodEntity);
            }

            throw new CustomException("Yetki Hatası.");
        }else{
            return foodDao.createOrUpdate(foodEntity);
        }
    }

    @Override
    public String deleteById(Long id,Long userId) throws CustomException {
        FoodEntity food = foodDao.getById(id);
        if(food.getUser() != null && food.getUser().getId() == userId){
            int result = foodDao.removeById(id);
            return result == 1 ? "İşlem başarılı." : "İşlem başarısız.";
        }

        return "İşlem başarısız.";

    }

    @Override
    public FoodEntity getById(Long id) {

        FoodEntity food = foodDao.getById(id);
        if (food != null){
            food.getImage().setImageByte(ImageUtility.decompressBytes(food.getImage().getImageByte()));
        }

        return food;
    }

    @Override
    public List<FoodEntity> search(String search) {
        return foodDao.search(search);
    }

    @Override
    public FoodEntity newCreateOrUpdate(MultipartFile file, String json,Long userId) throws CustomException{
        try {

            FoodDto foodDto = new ObjectMapper().readValue(json,FoodDto.class);

            FoodEntity foodEntity = null;

            if(foodDto.getId() != null){
                foodEntity = foodDao.getById(foodDto.getId());
            }else{
                foodEntity = new FoodEntity();
                foodEntity.setCreateDate(new Date());
            }
            foodEntity.setTitle(foodDto.getTitle());
            foodEntity.setDescription(foodDto.getDescription());
            foodEntity.setFoodDetails(foodDto.getFoodDetails());

            if(userId != null){

                UserEntity currentUser = authDao.getByUserId(userId);
                foodEntity.setUser(currentUser);
            }

            ImageEntity image = new ImageEntity(file.getOriginalFilename(),file.getContentType(), ImageUtility.compressBytes(file.getBytes()));

            foodEntity.setImage(image);
            image.setFood(foodEntity);



           if (foodEntity.getId() != null){

                if(foodEntity.getUser() != null && foodEntity.getUser().getId() == userId){
                    return foodDao.createOrUpdate(foodEntity);
                }
                throw new CustomException("Yetki Hatası.");
            }

            return foodDao.createOrUpdate(foodEntity);

        }catch (Exception ex){

            throw new CustomException(ex.getMessage());
        }

    }
}
