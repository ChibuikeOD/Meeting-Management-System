package com.Team4.SWENG455.SWENG._5.Project.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Team4.SWENG455.SWENG._5.Project.model.User;


public interface UserRepo extends MongoRepository<User, String>
{
	 Optional<User> findByEmail(String email);
}
