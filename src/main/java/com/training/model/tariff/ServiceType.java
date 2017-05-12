package com.training.model.tariff;

import com.training.controller.localization.ResourceManager;

public enum ServiceType {
	CALL(
			new ServicefVatiant[]{
			new ServicefVatiant(ResourceManager.INSTANCE.getString("ServiceType.call.name.1"),1000,100,ResourceManager.INSTANCE.getString("ServiceType.call.units")), 
			new ServicefVatiant(ResourceManager.INSTANCE.getString("ServiceType.call.name.2"),2000,200,ResourceManager.INSTANCE.getString("ServiceType.call.units")), 
			new ServicefVatiant(ResourceManager.INSTANCE.getString("ServiceType.call.name.3"),3000,300,ResourceManager.INSTANCE.getString("ServiceType.call.units")) 
			}), 
	INTERNET(
			new ServicefVatiant[]{
			new ServicefVatiant(ResourceManager.INSTANCE.getString("ServiceType.internet.name.1"),1500,1000,ResourceManager.INSTANCE.getString("ServiceType.internet.units")), 
			new ServicefVatiant(ResourceManager.INSTANCE.getString("ServiceType.internet.name.2"),2500,2000,ResourceManager.INSTANCE.getString("ServiceType.internet.units")), 
			new ServicefVatiant(ResourceManager.INSTANCE.getString("ServiceType.internet.name.3"),3500,3000,ResourceManager.INSTANCE.getString("ServiceType.internet.units")) 
			}), 
	SMS(
			new ServicefVatiant[]{
			new ServicefVatiant(ResourceManager.INSTANCE.getString("ServiceType.sms.name.1"),100,10,ResourceManager.INSTANCE.getString("ServiceType.sms.units")), 
			new ServicefVatiant(ResourceManager.INSTANCE.getString("ServiceType.sms.name.2"),200,20,ResourceManager.INSTANCE.getString("ServiceType.sms.units")),
			new ServicefVatiant(ResourceManager.INSTANCE.getString("ServiceType.sms.name.3"),300,30,ResourceManager.INSTANCE.getString("ServiceType.sms.units")) 
			});
	
	
	private ServicefVatiant[] variants;
	
	private ServiceType(ServicefVatiant[] variants){
		this.variants=variants;
	}
	
	public ServicefVatiant[] getVariants() {
		return variants;
	}
		
}