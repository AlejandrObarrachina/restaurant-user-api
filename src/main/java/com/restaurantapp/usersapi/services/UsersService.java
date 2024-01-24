package com.restaurantapp.usersapi.services;


import com.restaurantapp.usersapi.models.User;
import com.restaurantapp.usersapi.models.entities.UserEntity;
import com.restaurantapp.usersapi.repository.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UsersService implements IUserService{
    private final UsersRepository repository;

    public UsersService(UsersRepository repository) {
        this.repository = repository;
    }

    public List<UserEntity> getUsers() {
        return repository.findAll();
    }

    public UserEntity getUserById(@PathVariable Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Id"));
    }
    public UserEntity addUser(UserEntity user) throws Exception {
        if (!repository.existsByUsername(user.getUsername())) {
            return repository.save(user);

        } else {
            throw new Exception("this user already exists!");

        }
    }
    public void UpdateUser(Long id, User user) throws Exception {
       UserEntity userEntity = repository.findById(id).orElseThrow(() -> new Exception("Id NOT found"));
       userEntity.setUsername(user.getUsername());
       userEntity.setPassword(user.getPassword());
       userEntity.setEmail(user.getEmail());
       userEntity.setProfilePic(user.getProfilePic());
       repository.save(userEntity);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }


}
