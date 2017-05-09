package com.training.model.utils;

import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;

import com.training.model.services.Service;
import com.training.model.services.ServiceType;
import com.training.model.services.ServicefVatiant;
import com.training.model.services.SuspendedState;
import com.training.model.services.Tariff;
import com.training.view.View;

public class TariffUtils {

	View view = new View();

	public Tariff createTariff() {
		Tariff tariff = new Tariff();
		Map<ServiceType, Service> services = new EnumMap<>(ServiceType.class);
		for (ServiceType serviceType : ServiceType.values()) {
			view.print(View.CHOUSE_SERVICE + " " + serviceType.name());
			int option = readNumber();
			if (option == 0) {
				view.print(View.CHOUSE_VARIANT);
				int i = 0;
				for (ServicefVatiant variant : serviceType.getVariants()) {
					view.print(i++ + " " + variant.toString());
				}
				option = readNumber(serviceType.getVariants().length);

				Service service = new Service(serviceType.getVariants()[option]);
				service.setState(new SuspendedState());
				services.put(serviceType, service);
			}
		}
		tariff.setServices(services);
		return tariff;
	}
	public Tariff createRandomTariff() {
		Tariff tariff = new Tariff();
		Map<ServiceType, Service> services = new EnumMap<>(ServiceType.class);
		for (ServiceType serviceType : ServiceType.values()) {
				int option = (int)(Math.random()*(serviceType.getVariants().length));
				Service service = new Service(serviceType.getVariants()[option]);
				service.setState(new SuspendedState());
				services.put(serviceType, service);
			
		}
		tariff.setServices(services);
		return tariff;
	}

	private int readNumber() {
		Scanner sc = new Scanner(System.in);
		while (!sc.hasNextInt()) {
			view.print(View.WRONG_UNMERIC_INPUT);
			sc.next();
		}
		return sc.nextInt();
	}

	private int readNumber(int border) {
		Scanner sc = new Scanner(System.in);
		int i;
		do {
			while (!sc.hasNextInt()) {
				view.print(View.WRONG_UNMERIC_INPUT);
				sc.next();
			}
			i = sc.nextInt();
		} while (i > border - 1);
		return i;
	}

}