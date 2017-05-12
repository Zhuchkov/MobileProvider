package com.training.controller.services.search;

import java.util.LinkedList;
import java.util.List;

import com.training.model.tariff.ServiceType;

public class QuerryBuilder {
	List<Operator> operators = new LinkedList<>();
	
	QuerryBuilder(){
		
	}

	public QuerryBuilder addOperrator(ServiceType type, SearchParameter param, int leftBorder, int rightBorder) {
		Operator operator = operatorFactory( type,param, leftBorder, rightBorder);
		operators.add(operator);
		return this;
	}

	private Operator operatorFactory(ServiceType type, SearchParameter param, int leftBorder, int rightBorder) {
		switch (param) {
		case AMOUNT:
			return new AmountOperator(type, leftBorder, rightBorder);
		case COST:
			return new CostOperator(type, leftBorder, rightBorder);
		}
		return null;
	}

	public Querry build() {
		return new Querry(operators);
	}
	
}
