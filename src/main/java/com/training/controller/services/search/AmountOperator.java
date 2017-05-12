package com.training.controller.services.search;

import java.util.Iterator;
import java.util.List;

import com.training.model.tariff.ServiceType;
import com.training.model.tariff.Tariff;

public class AmountOperator extends Operator{
	 AmountOperator(ServiceType type, int leftBorder, int rightBorder) {
		super(type, leftBorder, rightBorder);
	}

	public void execute(List<Tariff> tariffs) {
		Iterator<Tariff> it = tariffs.iterator();
		while(it.hasNext()){
			int amount = it.next().getServiceOfType(type).getAmount();
			if (amount < leftBorder || amount > rightBorder) {
				it.remove();
			}
		}
	}
}
