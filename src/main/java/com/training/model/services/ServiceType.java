package com.training.model.services;

public enum ServiceType {
	CALL(
			new ServicefVatiant[]{
			new ServicefVatiant("lite",1000,100,"minutes"),
			new ServicefVatiant("mid",2000,200,"minutes"),
			new ServicefVatiant("large",3000,300,"minutes")
			}), 
	INTERNET(
			new ServicefVatiant[]{
			new ServicefVatiant("lite",1500,1000,"Mbytes"),
			new ServicefVatiant("mid",2500,2000,"Mbytes"),
			new ServicefVatiant("large",3500,3000,"Mbytes")
			}), 
	SMS(
			new ServicefVatiant[]{
			new ServicefVatiant("lite",100,10,"items"),
			new ServicefVatiant("mid",200,20,"items"),
			new ServicefVatiant("large",300,30,"items")
			});
	
	
	private ServicefVatiant[] variants;
	
	private ServiceType(ServicefVatiant[] variants){
		this.variants=variants;
	}
	
	public ServicefVatiant[] getVariants() {
		return variants;
	}
		
}