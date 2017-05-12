package com.training.model.DAO;

import java.util.List;

public interface DAO<T> {
	
	List<T> getAll();
	
}
