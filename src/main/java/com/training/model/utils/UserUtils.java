package com.training.model.utils;

import java.util.LinkedList;
import java.util.List;

import com.training.model.Account;
import com.training.model.User;

public class UserUtils {
	
	TariffUtils builder = new TariffUtils();
	
	public List<User> init(){
		List<User> users = new LinkedList<>();
		for(int i=0; i<20; i++){
			User user = new User();
			Account acc = new Account();
			acc.setTariff(builder.createRandomTariff());
			user.setAccount(acc); 
			users.add(user);
		}
		return users;
	}

}
