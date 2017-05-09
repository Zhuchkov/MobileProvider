package com.training.model.utils.search;

import java.util.Iterator;
import java.util.List;

import com.training.model.services.ServiceType;
import com.training.model.services.Tariff;

public class CostOperator extends Operator {

	 CostOperator(ServiceType type, int leftBorder, int rightBorder) {
		super(type, leftBorder, rightBorder);
	}

	public void execute(List<Tariff> tariffs) {
		Iterator<Tariff> it = tariffs.iterator();
		while(it.hasNext()){
			int amount = it.next().getServiceOfType(type).getFee();
			if (amount < leftBorder || amount > rightBorder) {
				it.remove();
			}
		}
	}
}