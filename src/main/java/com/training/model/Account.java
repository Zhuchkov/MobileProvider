package com.training.model;

import com.training.model.services.ServiceType;
import com.training.model.services.Tariff;
import com.training.model.services.exceptions.ServiceNotUsedException;
import com.training.model.services.exceptions.ServiceSuspendedException;

public class Account {

	private String number;
	
	private int balance = 0;
	
	private Tariff tariff;
	
	public int getSubscriptionFee(){
		return tariff.getSubscriptionFee();
	}

	public void perfomAction(ServiceType type, int amount) throws ServiceSuspendedException, ServiceNotUsedException{
		tariff.useService(type,amount);
	}
	public void addBalance(int amount){
		balance+=amount;
		tariff.notifyServices(this,false);
	}
	
	private void monthlyPay(){
		tariff.notifyServices(this,true);
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Tariff getTariff() {
		return tariff;
	}

	public void setTariff(Tariff tariff) {
		this.tariff = tariff;
	}
	
}
