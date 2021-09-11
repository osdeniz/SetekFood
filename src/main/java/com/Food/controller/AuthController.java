package com.Food.controller;


import com.Food.entity.UserEntity;
import com.Food.model.dto.UserDto;
import com.Food.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/auth", produces = "application/json")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public UserEntity register(@RequestBody UserDto userDto){
        return authService.create(userDto);
    }

    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public UserEntity update(@RequestBody UserDto userDto) throws Exception {
        return authService.update(userDto);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id){
        return authService.removeUser(id);
    }

    @RequestMapping(value="users",method = RequestMethod.GET)
    public List<UserEntity> getUsers(){
        return authService.getUsers();
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public UserEntity getUserInfoById(@PathVariable long id){
        return authService.getById(id);
    }


}
