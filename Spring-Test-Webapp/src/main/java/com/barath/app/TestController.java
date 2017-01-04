package com.barath.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	
	@GetMapping("/getMess")
	public String testMessage(){
		return "hello test";
	}
	
	
	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable("id") String id){
		
		long userId=Long.parseLong(id);
		
		User user=loadUsers().stream().filter(u -> u.getUserId() == userId).collect(Collectors.toList()).get(0);
		System.out.println("User "+user.toString());
		return user;
	}
	
	
	
	
	
	
	
	protected static class User{
		
		private long userId;
		
		private String userName;

		public long getUserId() {
			return userId;
		}

		public void setUserId(long userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public User(long userId, String userName) {
			super();
			this.userId = userId;
			this.userName = userName;
		}

		public User() {
			super();
			
		}

		@Override
		public String toString() {
			return "User [userId=" + userId + ", userName=" + userName + "]";
		}
		
		
		
		
	}
	
	private List<User> loadUsers(){
		
		return Arrays.asList(new User(1000, "Barath"),new User(1001,"Ravie"));
		
	}

}
