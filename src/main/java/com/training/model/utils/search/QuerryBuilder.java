package com.training.model.utils.search;

import java.util.LinkedList;
import java.util.List;

import com.training.model.services.ServiceType;

public class QuerryBuilder {
	List<Operator> operators = new LinkedList<>();
	
	QuerryBuilder(){
		
	}

	public QuerryBuilder addOperrator(ServiceType type, SearchParameter param, int leftBorder, int rightBorder) {
		Operator operator = operatorFactory(param, type, leftBorder, rightBorder);
		operators.add(operator);
		return this;
	}

	private Operator operatorFactory(SearchParameter param, ServiceType type, int leftBorder, int rightBorder) {
		switch (param) {
		case AMOUNT:
			return new AmountOperator(type, leftBorder, rightBorder);
		case COST:
			return new CostOperator(type, leftBorder, rightBorder);
		}
		return null;
	}

	public List<Operator> build() {
		return operators;
	}
}
