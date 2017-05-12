package com.training.model.utils;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.training.model.tariff.Service;
import com.training.model.tariff.ServiceType;
import com.training.model.tariff.SuspendedState;
import com.training.model.tariff.Tariff;
import com.training.view.View;

public class TariffUtils {

	View view = new View();



	public List<Tariff> createRandomTariffs(int quantity) {
		Set<Tariff> tarifs = new HashSet<>();
		for (int i = 0; i < quantity; i++) {
			Tariff tariff;
			do {
				tariff = createRandomTariff();
			} while (!tarifs.add(tariff));
		}
		List<Tariff> result = new ArrayList<>(tarifs);
		return result;
	}

	Tariff createRandomTariff() {
		Tariff tariff = new Tariff();
		Map<ServiceType, Service> services = new EnumMap<>(ServiceType.class);
		for (ServiceType serviceType : ServiceType.values()) {
			int option = (int) (Math.random() * (serviceType.getVariants().length));
			Service service = new Service(serviceType.getVariants()[option]);
			service.setState(new SuspendedState());
			services.put(serviceType, service);

		}
		tariff.setServices(services);
		return tariff;
	}

	

}