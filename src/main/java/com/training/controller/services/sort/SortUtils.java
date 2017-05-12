package com.training.controller.services.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.training.model.tariff.Tariff;

public class SortUtils {

	public List<Tariff> sortTariffs(List<Tariff> tariffs,Comparator<Tariff> comparator){
		List <Tariff> sortedTariffs = new ArrayList<>(tariffs);
		Collections.sort(tariffs,comparator);
		return sortedTariffs;
	}
	
	public Comparator<Tariff> getByFeeComparator(){
		return new SortByFee();
	}
	
	
	
class SortByFee implements Comparator<Tariff>{
		@Override
		public int compare(Tariff o1, Tariff o2) {
			int fee1 = o1.getSubscriptionFee();
			int fee2 = o2.getSubscriptionFee();
			if(fee1>fee2){
				return 1;
			}else if(fee1<fee2){
				return -1;
			}else{
				return 0;
			}
			
		}
		
	}
}
