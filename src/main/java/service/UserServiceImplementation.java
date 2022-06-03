package service;

import java.util.UUID;

import model.User;

public class UserServiceImplementation implements UserService{

	public User createUser(String firstname, String lastname, String email, String password, String repeatPassword) {
		// TODO Auto-generated method stub
		if (firstname == null || firstname.trim().length() == 0) {
			throw new IllegalArgumentException("User first name is empty");
		}
		
		if (lastname == null || lastname.trim().length() == 0) {
			throw new IllegalArgumentException("User last name is empty");
		}
		
		
		return new User (firstname, lastname, email, UUID.randomUUID().toString());
	}

	
}
