package com.blindterran.springbootrest.repo;

import com.blindterran.springbootrest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);

}
