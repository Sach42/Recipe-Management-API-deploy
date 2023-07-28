package com.sachin.Recipe.management.system.repository;

import com.sachin.Recipe.management.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Long> {
}
