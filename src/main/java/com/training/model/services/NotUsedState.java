package com.training.model.services;

import com.training.model.Account;
import com.training.model.services.exceptions.ServiceNotUsedException;
import com.training.model.services.exceptions.ServiceSuspendedException;

public class NotUsedState implements State {

	@Override
	public void withdrawFee(Account account, Service abstractService, boolean monthlyPayment) {

	}

	@Override
	public void perfomServiceAction(int amount, Service abstractService) throws ServiceSuspendedException, ServiceNotUsedException {
		//TODO implement activation
		throw new ServiceNotUsedException();
	}

	@Override
	public int getFee(Service abstractService) {
		return 0;
	}

}
