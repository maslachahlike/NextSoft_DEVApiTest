package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import model.User;

public class UserServiceTest {

	//ditaruh sini supaya bisa diakes semua method
	//jadi tiap method ga perlu diinisiasi lagi
	UserService userService;
	String firstname;
	String lastname;
	String email;
	String password;
	String repeatPassword;
	
	
	@BeforeEach
	public void init() {
		userService = new UserServiceImplementation();
		firstname = "Maslachah";
		lastname = "Awwaliyah";
		email = "maslachahawwaliyah@gmail.com";
		password = "rahasia";
		repeatPassword = "rahasia";
			
	}

	//green - positif test
	@DisplayName("User object is created")
	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	public void testCreateUser_WhenDetailIsProvide_ReturnUserObject() {
		
		//Arrange
		//kalau sudah dideklarasi di public class ga perlu lagi ditulis di sini
//=================================================================
//		UserService userService = new UserServiceImplementation();
//		String firstname = "Like";
//		String lastname = "Awwaliyah";
//		String email= "maslachahawwaliyah@gmail.com";
//		String password = "rahasia";
//		String repeatPassword = "rahasia";
//=================================================================
		
		//Act
		
		User user = userService.createUser(firstname, lastname, email, password, repeatPassword);
		
		assertTimeout(Duration.ofMillis(500), ()->{
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
		});
		//Assert
		
		assertNotNull(user, "if createuser success should not return null");
		assertEquals(firstname, user.getFirstName(), "User first name is incorrect");
		assertEquals(lastname, user.getLastName(), "User last name is incorrect");
		assertEquals(email, user.getEmail(), "User email is incorrect");
		assertNotNull(user.getId(), "User email cannot null");
		
		
	}
	
	//negatif - red test
	@Test
	@DisplayName("Empty First Name CauseException")
	public void testCreateUser_WhenFirstNameIsEmpty_ThrowsIllegalException() {
	
		//Arrange
		String firstname = "";
		String exceptedExceptionMassage = "User first name is empty";
		
		
		//Act
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () ->{
			userService.createUser(firstname, lastname, email, password, repeatPassword);
		}, "Empty first name cause illegal argument exception");
		
		//Assert
		assertEquals(exceptedExceptionMassage, thrown.getMessage());
	}
	
	//negatif - red test
	@Test
	@DisplayName("Empty Last Name Cause Exception")
	public void testCreateUser_WhenLastNameIsEmpty_ThrowsIllegalException() {
		
			//Arrange
			String lastname = "";
			String exceptedExceptionMassage = "User last name is empty";
			
			
			//Act
			IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () ->{
				userService.createUser(firstname, lastname, email, password, repeatPassword);
			}, "Empty last name cause illegal argument exception");
			
			//Assert
			assertEquals(exceptedExceptionMassage, thrown.getMessage());
		}
	
	
}
