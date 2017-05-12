package com.training.model.tariff;

import com.training.controller.localization.ResourceManager;
import com.training.model.Account;
import com.training.model.tariff.exceptions.ServiceNotUsedException;
import com.training.model.tariff.exceptions.ServiceSuspendedException;
import com.training.view.View;

public class Service {

	
	private String name;
	private int cost;
	private int amount;
	private String units;
	
	private State activeState = new ActiveState();
	private State suspendedState = new SuspendedState();
	private State notUsedState = new NotUsedState();

	private State currentState;

	public Service(){
		
	}
	
	public Service(String name, int cost, int amount,String units) {
		this.setName(name);
		this.cost = cost;
		this.amount = amount;
		this.units=units;
	}

	public Service(ServicefVatiant servicefVatiant) {
		this.setName(servicefVatiant.getName());
		this.cost = servicefVatiant.getCost();
		this.amount = servicefVatiant.getAmount();
		this.units=servicefVatiant.getAmountMeasermentUnits();
	}

	public int getFee() {
		return currentState.getFee(this);
	}

	public void withdrawFee(Account account, boolean monthlyPayment) {
		currentState.withdrawFee(account,this,monthlyPayment);
	}

	public void use(int amount) throws ServiceSuspendedException, ServiceNotUsedException {
		currentState.perfomServiceAction(amount,this);
	}
	
	public void setState(State newState){
		currentState = newState;
	}
	
	public State getActiveState(){
		return activeState;
	}
	public State getSuspendedState(){
		return suspendedState;
	}
	public State getNotUsedState(){
		return notUsedState;
	}

	int getCost(){
		return cost;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + cost;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Service other = (Service) obj;
		if (amount != other.amount)
			return false;
		if (cost != other.cost)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return	String.format(ResourceManager.INSTANCE.getString(View.SERVICE_DESCRIPTION), name,cost,amount,units) ;
		
	}
	

}
