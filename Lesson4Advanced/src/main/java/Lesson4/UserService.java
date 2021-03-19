package Lesson4;

import java.util.ArrayList;
import java.util.List;

public class UserService {

	
	
	
	private static UserService userService;
	
	private List <User> userlist = new ArrayList<>();
	
	public  List<User> getUserList() {
		return userlist;		
	}
	
	private UserService() {}

	public static UserService getUserService() {
		if(userService == null) {
			userService = new UserService();
		}
		return userService;
	}
	
	public void addUser(User user) {
		userlist.add(user);
	}
	
	public User getUser(String email) {
		
		return userlist.stream().filter(user->user.getEmail().equals(email)).findAny().orElse(null);
	}
	
}
