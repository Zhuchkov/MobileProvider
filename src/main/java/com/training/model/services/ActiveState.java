package com.training.model.services;

import com.training.model.Account;

public class ActiveState implements State {

	

	@Override
	public void withdrawFee(Account account, Service service,boolean monthlyPayment) {
		if(monthlyPayment&&(account.getBalance()>service.getFee())){
			account.setBalance(account.getBalance()-service.getFee());
			System.out.println(service.getName()+" payded");
		}else{
			System.out.println(service.getName()+" suspended");
			service.setState(service.getSuspendedState());
		}
	}

	@Override
	public void perfomServiceAction(int amount, Service service) {
		if(amount<service.getAmount()){
			service.setAmount(service.getAmount()-amount);
			System.out.println(service.getName()+" action");
		}else{
			service.setState(service.getSuspendedState());
			System.out.println(service.getName()+" suspended");
		}
	}

	@Override
	public int getFee(Service service) {
		return service.getCost();
	}
}
