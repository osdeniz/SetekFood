package com.Food.repository;

import com.Food.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<UserEntity,Long> {
}
