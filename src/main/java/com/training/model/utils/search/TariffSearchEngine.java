package com.training.model.utils.search;

import java.util.LinkedList;
import java.util.List;

import com.training.model.services.Tariff;

public class TariffSearchEngine {

	private List<Tariff> tariffs;
	private List<Operator> querry;

	public TariffSearchEngine(List<Tariff> tariffs) {
		this.tariffs = tariffs;
	}

	public List<Tariff> executeOperators() {
		List<Tariff> tariffs = new LinkedList<>(this.tariffs);
		for (Operator operator : querry) {
			operator.execute(tariffs);
		}
		return tariffs;
	}
	public QuerryBuilder getQuerryBuilder(){
		return new QuerryBuilder();
	}
	
	public void setQuerry(QuerryBuilder builder){
		querry=builder.build();
	}
}





