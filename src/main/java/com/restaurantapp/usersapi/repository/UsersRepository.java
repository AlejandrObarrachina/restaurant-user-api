package com.restaurantapp.usersapi.repository;

import com.restaurantapp.usersapi.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUsername(String username);
}