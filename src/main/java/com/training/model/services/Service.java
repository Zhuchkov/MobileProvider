package com.training.model.services;

import com.training.model.Account;
import com.training.model.services.exceptions.ServiceNotUsedException;
import com.training.model.services.exceptions.ServiceSuspendedException;

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
	public String toString() {
		return "[name=" + name + ", cost=" + cost + ", amount=" + amount+"("+units+")" + ", currentState=" + currentState + "]";
	}
	

}
