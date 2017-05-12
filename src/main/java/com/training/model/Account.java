package com.training.model;

import com.training.model.tariff.ServiceType;
import com.training.model.tariff.Tariff;
import com.training.model.tariff.exceptions.ServiceNotUsedException;
import com.training.model.tariff.exceptions.ServiceSuspendedException;

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
	
	public void monthlyPay(){
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
