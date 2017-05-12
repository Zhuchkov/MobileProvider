package com.training.model.tariff;

import com.training.model.Account;
import com.training.model.tariff.exceptions.ServiceNotUsedException;
import com.training.model.tariff.exceptions.ServiceSuspendedException;

public interface State {

	

	 void withdrawFee(Account account, Service abstractService, boolean monthlyPayment);

	 void perfomServiceAction(int amount, Service abstractService) throws ServiceSuspendedException, ServiceNotUsedException;

	 int getFee(Service abstractService);

}
