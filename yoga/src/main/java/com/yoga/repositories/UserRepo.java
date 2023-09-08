package com.yoga.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yoga.models.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	 Optional<User> findByEmail(String email);
	 Optional<User> findByName(String name);
	 
}
