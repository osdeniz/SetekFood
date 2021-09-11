package com.Food.dao;

import com.Food.entity.UserEntity;

import java.util.List;

public interface IAuthDao {

    UserEntity register(UserEntity userEntity);

    UserEntity update(UserEntity userEntity);

    UserEntity getByUserId(long id);

    int removeById(Long id);

    List<UserEntity> getUsers();

}
