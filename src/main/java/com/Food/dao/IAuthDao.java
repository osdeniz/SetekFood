package com.Food.dao;

import com.Food.entity.UserEntity;

public interface IAuthDao {

    UserEntity register(UserEntity userEntity);

    UserEntity update(UserEntity userEntity);

    UserEntity getByUserId(Long id);

    int removeById(Long id);

}
