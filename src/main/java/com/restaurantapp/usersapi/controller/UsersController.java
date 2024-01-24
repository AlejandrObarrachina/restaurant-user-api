package com.restaurantapp.usersapi.controller;

import com.restaurantapp.usersapi.mappers.UsersMapper;
import com.restaurantapp.usersapi.models.User;
import com.restaurantapp.usersapi.services.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UsersController {
    private final UsersService service;
    private final UsersMapper mapper;

    public UsersController(UsersService service, UsersMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "/user")
    public List<User> getUsers(){
        return mapper.UserEntityListToModelList(service.getUsers());
    }

    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable Long id) throws Exception {
        return mapper.UserEntityToModel(service.getUserById(id));
    }

    @PostMapping(value = "/user")
    public void addUser(@RequestBody User user) throws Exception {
        service.addUser(mapper.UserModelToEntity(user));
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody User newUser) throws Exception {
        Long newRestaurant = service.addUser(mapper.UserModelToEntity(newUser)).getId();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newRestaurant)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }
}
