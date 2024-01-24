package com.restaurantapp.usersapi.initializer;


import com.restaurantapp.usersapi.models.entities.UserEntity;
import com.restaurantapp.usersapi.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final UsersRepository repository;

    public DatabaseLoader(UsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        this.repository.save(new UserEntity(1L,"Paco","a@gmail.com","12345a", "https://cdn1.iconfinder.com/data/icons/fast-food-and-restaurant-meals-1/128/Indian_Curry-512.png"));
    }
}