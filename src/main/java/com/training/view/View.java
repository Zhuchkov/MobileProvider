package com.training.view;

import java.util.List;

import com.training.controller.localization.ResourceManager;
import com.training.model.tariff.Tariff;

public class View {
	
	public static final String SERVICE_DESCRIPTION = "output.description.service";
	public static final String SERVICEVARIANT_DESCRIPTION = "output.description.cervicevariant";
	
	public static final String SEARCH_CONFORMATION_REQUEST ="request.search.conformation"; 
	public static final String SEARCH_HIGH_BOUNDARY_REQUEST = "request.search.boundary.high";
	public static final String SEARCH_LOW_BOUNDARY_REQUEST = "request.search.boudary.low"; 
	public static final String SEARCH_PARAMETER_REQUEST ="request.search.parameter"; 
	public static final String SEARCH_SERVICE_REQUEST = "request.search.service"; 
	public static final String MENU_OPTION_LIST = "output.menu.optionlist"; 
	

	public static final String WRONG_UNMERIC_INPUT = "input.error.number"; 
	public static final String WRONG_UNMERIC_INPUT_OUT_OF_BORDER = "input.error.out-of-border"; 
	public static final String REQUEST_INPUT_LANGUAGE = "request.input.language";

	public void print(String message) {
		System.out.println(ResourceManager.INSTANCE.getString(message));

	}

	public void print(List<Tariff> tariffs) {
		if (tariffs.size() != 0) {
			for (Tariff tariff : tariffs) {
				System.out.println(tariff);
			}

		}
		else{
			System.out.println(ResourceManager.INSTANCE.getString("input.error.empty")); //$NON-NLS-1$
		}
	}

}
