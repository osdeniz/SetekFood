package com.Food.repository;

import com.Food.entity.ImageEntity;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<ImageEntity,Long> {
}
