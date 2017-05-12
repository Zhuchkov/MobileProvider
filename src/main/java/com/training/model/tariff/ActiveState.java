package com.training.model.tariff;

import com.training.model.Account;

public class ActiveState implements State {

	

	@Override
	public void withdrawFee(Account account, Service service,boolean monthlyPayment) {
		if(monthlyPayment&&(account.getBalance()>service.getFee())){
			account.setBalance(account.getBalance()-service.getFee());
		
		}else{
		
			service.setState(service.getSuspendedState());
		}
	}

	@Override
	public void perfomServiceAction(int amount, Service service) {
		if(amount<service.getAmount()){
			service.setAmount(service.getAmount()-amount);
		
		}else{
			service.setState(service.getSuspendedState());
		
		}
	}

	@Override
	public int getFee(Service service) {
		return service.getCost();
	}
}
