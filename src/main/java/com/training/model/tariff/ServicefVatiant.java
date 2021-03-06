package com.training.model.tariff;

import com.training.controller.localization.ResourceManager;
import com.training.view.View;

public class ServicefVatiant {


	private String name;
	private int cost;
	private int amount;
	private String amountMeasermentUnits;
	
	ServicefVatiant(String name, int cost, int amount, String amountMeasermentUnits) {
		this.name = name;
		this.cost = cost;
		this.amount = amount;
		this.amountMeasermentUnits = amountMeasermentUnits;
	}
	public String getName() {
		return name;
	}
	public int getCost() {
		return cost;
	}
	public int getAmount() {
		return amount;
	}
	public String getAmountMeasermentUnits() {
		return amountMeasermentUnits;
	}
	public void setAmountMeasermentUnits(String amountMeasermentUnits) {
		this.amountMeasermentUnits = amountMeasermentUnits;
	}
	@Override
	public String toString() {
		return String.format(ResourceManager.INSTANCE.getString(View.SERVICEVARIANT_DESCRIPTION), name,cost,amount);
	}
	
}
