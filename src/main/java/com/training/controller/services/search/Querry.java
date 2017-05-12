package com.training.controller.services.search;

import java.util.List;

import com.training.model.tariff.Tariff;

public class Querry {

	List<Operator> operators;
	
	 Querry(List<Operator> operators) {
		this.operators=operators;
	}

	
	void execute(List<Tariff> searchResult){
		for(Operator operator:operators){
			operator.execute(searchResult);
		}
	}
}
