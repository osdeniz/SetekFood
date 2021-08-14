package com.Food.service;

import com.Food.entity.UserEntity;
import com.Food.model.dto.UserDto;

public interface IAuthService {

    UserEntity create(UserDto userDto);

    UserEntity update(UserDto userDto) throws Exception;

    UserEntity getById(Long id);

    String removeUser(Long id);
}
