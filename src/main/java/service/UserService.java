package service;

import model.User;

public interface UserService {

	User createUser(String firstname, String lastname, String email, String password, String repeatPassword);

	//di interface ga perlu modifier dan return
	
}
