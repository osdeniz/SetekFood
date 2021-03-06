package com.Food.daoimpl;

import com.Food.dao.IAuthDao;
import com.Food.entity.UserEntity;
import com.Food.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthDaoImpl implements IAuthDao {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserEntity register(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity getByUserId(long id) {
        UserEntity user = userRepository.findById(id);
        return user;
    }

    @Override
    public int removeById(Long id) {
        userRepository.deleteById(id);
        return 1;
    }

    @Override
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }
}
