package com.restaurantapp.usersapi.mappers;

import com.restaurantapp.usersapi.models.User;
import com.restaurantapp.usersapi.models.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersMapper {

    public UserEntity UserModelToEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setUsername(user.getUsername());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setProfilePic(user.getProfilePic());
        return userEntity;
    }

    public User UserEntityToModel(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setEmail(userEntity.getEmail());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        user.setProfilePic(userEntity.getProfilePic());
        return user;
    }

    public List<User> UserEntityListToModelList(List<UserEntity> userEntityList) {
        return userEntityList.stream().map(this::UserEntityToModel).toList();
    }
}
