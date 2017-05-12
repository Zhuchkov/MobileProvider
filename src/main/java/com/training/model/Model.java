package com.training.model;

import java.util.List;

import com.training.model.DAO.DAO;
import com.training.model.tariff.Tariff;

public class Model {
	
	private DAO<User> userDao;
	private DAO<Tariff> tariffDao;
	private List<User> users;
	private List<Tariff> tariffs;
	
	public Model(DAO<User> userDao, DAO<Tariff> tariffDao) {
		this.userDao = userDao;
		this.tariffDao = tariffDao;
		users = userDao.getAll();
		tariffs = tariffDao.getAll();
	}

	
	public List<User> getUsers() {
		return users;
	}


	public List<Tariff> getTariffs() {
		return tariffs;
	}


	public int getUsersQuantity() {
		return users.size();
	}

}
