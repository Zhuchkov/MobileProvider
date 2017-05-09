package com.training.model.utils.search;

import java.util.List;

import com.training.model.services.ServiceType;
import com.training.model.services.Tariff;

public abstract class Operator {
	protected ServiceType type;
	protected int leftBorder;
	protected int rightBorder;

	public Operator(ServiceType type, int leftBorder, int rightBorder) {
		this.leftBorder = leftBorder;
		this.rightBorder = rightBorder;
		this.type = type;
	}

	public abstract void execute(List<Tariff> tariffs);
}
