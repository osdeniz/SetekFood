package com.Food.service;

    import com.Food.entity.FoodEntity;
    import com.Food.exception.CustomException;
    import com.Food.model.Food;
    import com.Food.model.dto.FoodDto;
    import org.springframework.web.multipart.MultipartFile;

    import java.util.List;

public interface IFoodService {

    List<FoodEntity> getAllList();

    FoodEntity createOrUpdate(FoodDto foodDto,Long userId) throws CustomException;

    String deleteById(Long id,Long userId) throws CustomException;

    FoodEntity getById(Long id);

    List<FoodEntity> search(String search);

    FoodEntity newCreateOrUpdate(MultipartFile file,String json,Long userId) throws CustomException;


}
