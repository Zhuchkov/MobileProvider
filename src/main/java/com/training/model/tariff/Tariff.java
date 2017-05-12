package com.training.model.tariff;

import java.util.Map;

import com.training.model.Account;
import com.training.model.tariff.exceptions.ServiceNotUsedException;
import com.training.model.tariff.exceptions.ServiceSuspendedException;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((services == null) ? 0 : services.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tariff other = (Tariff) obj;
		if (services == null) {
			if (other.services != null)
				return false;
		} else if (!services.equals(other.services))
			return false;
		return true;
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