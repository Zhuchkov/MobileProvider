package com.training.model.utils;

import java.util.LinkedList;
import java.util.List;

import com.training.model.User;

public class UserUtils {
	
	AccountUtils accoutnUtils = new AccountUtils();

	public List<User> createRandomAccounts(int quantity){
		List<User> users = new LinkedList<>();
		for(int i=0; i<quantity; i++){
			User user = new User();
			user.setAccount(accoutnUtils.createRandomAccount()); 
			users.add(user);
		}
		return users;
	}

	

}
