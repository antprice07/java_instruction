package com.maxtrain.bootcamp.prs.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByUsernameAndPassword(String username, String password);

}
