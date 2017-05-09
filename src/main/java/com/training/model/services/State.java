package com.training.model.services;

import com.training.model.Account;
import com.training.model.services.exceptions.ServiceNotUsedException;
import com.training.model.services.exceptions.ServiceSuspendedException;

public interface State {

	

	 void withdrawFee(Account account, Service abstractService, boolean monthlyPayment);

	 void perfomServiceAction(int amount, Service abstractService) throws ServiceSuspendedException, ServiceNotUsedException;

	 int getFee(Service abstractService);

}
