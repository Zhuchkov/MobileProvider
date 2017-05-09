package com.training.model.services;

import com.training.model.Account;
import com.training.model.services.exceptions.ServiceSuspendedException;

public class SuspendedState implements State {

	@Override
	public void withdrawFee(Account account, Service service, boolean monthlyPayment) {
		if (account.getBalance() > service.getFee()) {
			account.setBalance(account.getBalance() - service.getFee());
			service.setState(service.getActiveState());
			System.out.println(service.getName()+" activated");
		}
	}

	@Override
	public void perfomServiceAction(int amount, Service service) throws ServiceSuspendedException {
		throw new ServiceSuspendedException();

	}

	@Override
	public int getFee(Service service) {

		return service.getCost();
	}

}
