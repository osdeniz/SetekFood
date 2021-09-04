package com.Food.serviceimpl;

import com.Food.dao.IAuthDao;
import com.Food.entity.UserEntity;
import com.Food.model.dto.UserDto;
import com.Food.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private IAuthDao authDao;

    @Override
    public UserEntity create(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());
        return authDao.register(userEntity);
    }

    @Override
    public UserEntity update(UserDto userDto) throws Exception {
        UserEntity user = authDao.getByUserId(userDto.getId());
        if(user == null){
            throw new Exception("Sistemde kayıtlı kullanıcı bulunamadı.");
        }

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setImage(userDto.getImage());
        user.setRole(userDto.getRole());

        return authDao.update(user);
    }

    @Override
    public UserEntity getById(Long id) {
        return authDao.getByUserId(id);
    }

    @Override
    public String removeUser(Long id) {
        int result = authDao.removeById(id);
        return result == 1 ? "İşlem başarılı.":"İşlem başarısız.";
    }

    @Override
    public List<UserEntity> getUsers() {
        return authDao.getUsers();
    }
}
