package com.training.model.DAO;

import java.util.List;

import com.training.model.tariff.Tariff;
import com.training.model.utils.TariffUtils;

public class FakeTariffDAO implements DAO<Tariff> {

	@Override
	public List<Tariff> getAll() {
		
		return new TariffUtils().createRandomTariffs(9);
	}

}
