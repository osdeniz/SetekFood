package com.Food.repository;

import com.Food.entity.FoodEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IFoodRepository extends CrudRepository<FoodEntity, Long> {

    List<FoodEntity> findAll();

    List<FoodEntity> findByTitleContainingOrDescriptionContaining(String title,String description);

}