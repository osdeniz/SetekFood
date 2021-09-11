package com.Food.repository;

import com.Food.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserRepository extends CrudRepository<UserEntity,Long> {

     List<UserEntity> findAll();

     UserEntity findById(long id);
}
