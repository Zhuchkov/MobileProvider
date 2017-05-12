package com.training.controller.services.search;

import java.util.LinkedList;
import java.util.List;

import com.training.model.tariff.Tariff;

public class TariffSearchEngine {

	private Querry querry;


	public List<Tariff> execute(List<Tariff> tariffs) {
		List<Tariff> searchResult = new LinkedList<>(tariffs);
		querry.execute(searchResult);
		return searchResult;
	}

	public QuerryBuilder getQuerryBuilder(){
		return new QuerryBuilder();
	}
	public void setQuerry(Querry querry){
		this.querry=querry;
	}
	
}





