package com.training.model.DAO;

import java.util.List;

import com.training.model.User;
import com.training.model.utils.UserUtils;

public class FakeUserDAO implements DAO<User> {

	@Override
	public List<User> getAll() {
		return new UserUtils().createRandomAccounts(20);
	}
}
