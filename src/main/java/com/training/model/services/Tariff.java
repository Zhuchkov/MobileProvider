package com.training.model.services;

import java.util.Map;

import com.training.model.Account;
import com.training.model.services.exceptions.ServiceNotUsedException;
import com.training.model.services.exceptions.ServiceSuspendedException;

public class Tariff {
	
	private Map<ServiceType,Service> services;

	public int getSubscriptionFee() {
		int cost=0;
		for(Service service:services.values()){
			cost+=service.getFee();
		}
		return cost;
	}

	
	public void notifyServices(Account account, boolean monthlyPayment) {
		for(Service service:services.values()){
			service.withdrawFee(account,monthlyPayment);
		}
	}

	public void useService(ServiceType type, int amount) throws ServiceSuspendedException, ServiceNotUsedException {
		getServiceOfType(type).use(amount);
		
	}

	public Service getServiceOfType(ServiceType type){
		return services.get(type);
	}
	void changeService(ServiceType type, Service newState){
		services.replace(type, newState);
	}
	public void setServices(Map<ServiceType,Service> services){
		this.services=services;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(ServiceType type:services.keySet()){
			sb.append(type.name()).append(":").append(services.get(type).toString()).append("\n");
		}
		return sb.toString();
	}
	
}